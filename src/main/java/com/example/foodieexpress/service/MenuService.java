package com.example.foodieexpress.service;

import com.example.foodieexpress.dto.request.MenuCreateRequestDTO;
import com.example.foodieexpress.dto.response.MenuResponseDTO;
import com.example.foodieexpress.entity.Menu;
import com.example.foodieexpress.entity.Restaurant;
import com.example.foodieexpress.exception.FoodieExpressException;
import com.example.foodieexpress.repository.MenuRepository;
import com.example.foodieexpress.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public MenuResponseDTO createMenu(MenuCreateRequestDTO menuCreateRequestDTO) {
        Restaurant restaurant = restaurantRepository.findById(menuCreateRequestDTO.restaurantId())
                .orElseThrow(() -> new FoodieExpressException("Restoran bulunamadı."));

        Menu newMenu = new Menu();
        newMenu.setRestaurant(restaurant);
        newMenu.setName(menuCreateRequestDTO.name());
        newMenu.setDescription(menuCreateRequestDTO.description());
        newMenu.setPrice(menuCreateRequestDTO.price());

        Menu savedMenu = menuRepository.save(newMenu);

        return new MenuResponseDTO(savedMenu.getId(), savedMenu.getRestaurant().getId(), savedMenu.getName(), savedMenu.getDescription(), savedMenu.getPrice());
    }

    public void deleteMenu(Long menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new FoodieExpressException("Menü öğesi bulunamadı."));

        menuRepository.delete(menu);
    }
}
