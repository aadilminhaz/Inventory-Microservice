package com.apnacompany.dukaan.service;

import com.apnacompany.dukaan.entity.Order;
import com.apnacompany.dukaan.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    public Optional<Order> getOrderById(Long orderId) {

        return orderRepo.findById(orderId);
    }

    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }
}
