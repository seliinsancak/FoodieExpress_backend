import com.example.foodieexpress.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.foodieexpress.dto.request.LoginRequestDto;
import org.foodieexpress.dto.request.RegisterRequestDto;
import org.foodieexpress.dto.request.ResetPasswordRequestDto;
import org.foodieexpress.entity.*;
import org.foodieexpress.entity.enums.EState;
import org.foodieexpress.entity.enums.EUserRole;
import org.foodieexpress.exception.ErrorType;
import org.foodieexpress.exception.FoodieExpressException;
import org.foodieexpress.mapper.UserMapper;
import org.foodieexpress.repository.UserRepository;
import org.foodieexpress.utility.EncryptionManager;
import org.foodieexpress.utility.JwtManager;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtManager jwtManager;
    private final EmailService emailService;
    private final CloudinaryService cloudinaryService;

    @Transactional
    public void register(RegisterRequestDto dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new FoodieExpressException(ErrorType.MAIL_ALREADY_EXIST);
        }

        User user = UserMapper.INSTANCE.fromRegisterDto(dto);
        String encryptedPassword = EncryptionManager.getEncryptedPassword(dto.password());
        user.setPassword(encryptedPassword);
        user.setEmail(dto.email());
        user.setState(EState.ACTIVE);
        user.setUserRole(EUserRole.CUSTOMER);
        userRepository.save(user);

        String verificationToken = jwtManager.createVerificationToken(user.getId(), user.getEmail());
        emailService.sendVerificationEmail(user.getEmail(), verificationToken);
    }

    public void verifyAccount(String token) {
        Optional<Long> userIdOpt = jwtManager.validateToken(token);
        if (userIdOpt.isEmpty()) {
            throw new FoodieExpressException(ErrorType.INVALID_TOKEN);
        }

        User user = userRepository.findById(userIdOpt.get()).orElseThrow(() -> new FoodieExpressException(ErrorType.USER_NOTFOUND));
        user.setIsMailVerified(true);
        userRepository.save(user);
    }

    public String login(LoginRequestDto dto) {
        String encryptedPassword = EncryptionManager.getEncryptedPassword(dto.password());

        User user = userRepository.findOptionalByEmailAndPassword(dto.email(), encryptedPassword)
                .orElseThrow(() -> new FoodieExpressException(ErrorType.INVALID_USERNAME_OR_PASSWORD));

        validateUser(user);

        return jwtManager.createUserToken(user.getId(), user.getUserRole());
    }

    private void validateUser(User user) {
        if (user.getState().equals(EState.PASSIVE)) {
            throw new FoodieExpressException(ErrorType.USER_IS_PASSIVE);
        }

        if (!user.getIsMailVerified()) {
            String verificationToken = jwtManager.createVerificationToken(user.getId(), user.getEmail());
            emailService.sendVerificationEmail(user.getEmail(), verificationToken);
            throw new FoodieExpressException(ErrorType.MAIL_NOT_VERIFIED);
        }
    }

    public Boolean forgotPassword(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) throw new FoodieExpressException(ErrorType.MAIL_NOT_FOUND);

        User user = userOptional.get();
        String token = jwtManager.createResetPasswordToken(user.getId(), email);
        emailService.sendResetPasswordEmail(email, token);
        return true;
    }

    public Boolean resetPassword(String token, ResetPasswordRequestDto dto) {
        User user = getUserByToken(token);
        if (!dto.password().equals(dto.rePassword())) throw new FoodieExpressException(ErrorType.PASSWORDS_NOT_MATCH);

        user.setPassword(EncryptionManager.getEncryptedPassword(dto.password()));
        userRepository.save(user);
        return true;
    }

    public User getUserByToken(String token) {
        Optional<Long> userIdOpt = jwtManager.validateToken(token);
        if (userIdOpt.isEmpty()) throw new FoodieExpressException(ErrorType.INVALID_TOKEN);

        return userRepository.findById(userIdOpt.get()).orElseThrow(() -> new FoodieExpressException(ErrorType.USER_NOTFOUND));
    }

    public void addAvatarToUser(String token, MultipartFile file) throws IOException {
        User user = getUserByToken(token);
        if (!user.getUserRole().equals(EUserRole.CUSTOMER)) {
            throw new FoodieExpressException(ErrorType.UNAUTHORIZED);
        }
        user.setAvatarUrl(cloudinaryService.uploadFile(file));
        userRepository.save(user);
    }

    public Long getTotalUserCount() {
        return userRepository.countByState(EState.ACTIVE);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}



