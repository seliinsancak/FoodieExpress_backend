package com.example.foodieexpress.service;

import com.example.foodieexpress.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public void save(Address address) {
        addressRepository.save(address);
    }

    public void saveAll(List<Address> addresses) {
        addressRepository.saveAll(addresses);
    }

    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }
}
