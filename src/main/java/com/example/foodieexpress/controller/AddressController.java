package com.example.foodieexpress.controller;

import com.example.foodieexpress.dto.request.AddressCreateRequestDTO;
import com.example.foodieexpress.dto.response.AddressResponseDTO;
import com.example.foodieexpress.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // Yeni adres oluşturma
    @PostMapping("/create")
    public ResponseEntity<AddressResponseDTO> createAddress(@RequestBody AddressCreateRequestDTO addressDTO) {
        AddressResponseDTO addressResponse = addressService.createAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressResponse);
    }

    // Kullanıcıya ait tüm adresleri getirme
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AddressResponseDTO>> getAddressesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(addressService.getAddressesByUserId(userId));
    }
}
