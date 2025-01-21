package com.example.foodieexpress.service;

import com.example.foodieexpress.dto.request.AddressCreateRequestDTO;
import com.example.foodieexpress.dto.response.AddressResponseDTO;
import com.example.foodieexpress.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final List<AddressResponseDTO> addresses = new ArrayList<>();
    private long addressIdCounter = 1;

    // Yeni adres ekleme
    public AddressResponseDTO createAddress(AddressCreateRequestDTO addressDTO) {
        AddressResponseDTO addressResponseDTO = new AddressResponseDTO(
                addressIdCounter++,
                addressDTO.userId(),
                addressDTO.addressLine(),
                addressDTO.city(),
                addressDTO.district(),
                addressDTO.postalCode()
        );
        addresses.add(addressResponseDTO);
        return addressResponseDTO;
    }

    // Kullanıcıya ait tüm adresleri getirme
    public List<AddressResponseDTO> getAddressesByUserId(Long userId) {
        List<AddressResponseDTO> userAddresses = new ArrayList<>();
        for (AddressResponseDTO address : addresses) {
            if (address.userId().equals(userId)) {
                userAddresses.add(address);
            }
        }
        return userAddresses;
    }
}
