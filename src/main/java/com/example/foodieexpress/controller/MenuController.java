package com.example.foodieexpress.controller;

import com.example.foodieexpress.dto.request.MenuCreateRequestDTO;
import com.example.foodieexpress.dto.response.MenuResponseDTO;
import com.example.foodieexpress.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // Yeni bir menü öğesi oluştur
    @PostMapping("/")
    public MenuResponseDTO createMenu(@RequestBody MenuCreateRequestDTO menuCreateRequestDTO) {
        return menuService.createMenu(menuCreateRequestDTO);
    }

    // Menü öğesini sil
    @DeleteMapping("/{menuId}")
    public void deleteMenu(@PathVariable Long menuId) {
        menuService.deleteMenu(menuId);
    }
}

