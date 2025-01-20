package com.example.foodieexpress.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;

    public <UserDetails> void save(UserDetails userDetails) {
        userDetailsRepository.save(userDetails);
    }

    public boolean existsByTcNoAndSgkNo(String tcNo, String sgkNo) {
        return userDetailsRepository.existsByTcNoAndSgkNo(tcNo, sgkNo);
    }

    public List<Long> findUserIdsWithUpcomingBirthdays(Long companyId) {
        return userDetailsRepository.findUserIdsWithUpcomingBirthdays(companyId);
    }

    public List<VwPersonelForUpcomingBirthday> findPersonelByIds(List<Long> ids) {
        return userDetailsRepository.findPersonelByIds(ids);
    }
}
