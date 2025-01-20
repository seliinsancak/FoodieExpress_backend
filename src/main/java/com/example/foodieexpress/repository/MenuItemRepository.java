package com.example.foodieexpress.repository;

import com.example.foodieexpress.entity.MenuItem;
import com.example.foodieexpress.entity.enums.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    List<MenuItem> findByCategory(MenuCategory category);

    List<MenuItem> findByMenuId(Long menuId);


}