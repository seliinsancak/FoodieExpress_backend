package com.example.foodieexpress.controller;

import com.example.foodieexpress.dto.request.OrderCreateRequestDTO;
import com.example.foodieexpress.dto.response.OrderResponseDTO;
import com.example.foodieexpress.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderCreateRequestDTO orderDTO) {
        OrderResponseDTO orderResponse = orderService.createOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
