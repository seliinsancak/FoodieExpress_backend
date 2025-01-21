package com.example.foodieexpress.service;

import com.example.foodieexpress.dto.OrderItemDTO;
import com.example.foodieexpress.dto.request.OrderCreateRequestDTO;
import com.example.foodieexpress.dto.response.OrderResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final List<OrderResponseDTO> orders = new ArrayList<>();
    private long orderIdCounter = 1;

    // Yeni sipariş oluşturma
    public OrderResponseDTO createOrder(OrderCreateRequestDTO orderDTO) {
        List<OrderItemDTO> orderItems = new ArrayList<>();
        for (var item : orderDTO.items()) {
            orderItems.add(new OrderItemDTO(item.menuItemId(), item.quantity(), 10.0));  // Birim fiyat örneği
        }
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO(orderIdCounter++, orderDTO.userId(), orderItems, orderDTO.totalPrice(), "Pending");
        orders.add(orderResponseDTO);
        return orderResponseDTO;
    }

    // Sipariş listesi almak
    public List<OrderResponseDTO> getAllOrders() {
        return orders;
    }
}
