package com.apnacompany.dukaan.controller;


import com.apnacompany.dukaan.entity.Line;
import com.apnacompany.dukaan.entity.Order;
import com.apnacompany.dukaan.repo.OrderRepo;
import com.apnacompany.dukaan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepo orderRepo;


    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrders() {
        List<Order> orderResponse = orderRepo.findAll();


        if (orderResponse == null || orderResponse.isEmpty()) {
            return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Order>(orderResponse.get(0), HttpStatus.OK);

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrderById(@PathVariable("id")  Long id) {
        Optional<Order> orderResponse = orderService.getOrderById(id);


        if (!orderResponse.isPresent()) {
            return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Order>(orderResponse.get(), HttpStatus.OK);

    }


    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> loadSampleData(@RequestBody Order order) {

        if (!Optional.ofNullable(order).isPresent()) {
            return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Order>(orderService.saveOrder(order),HttpStatus.OK);
    }

    /**EXTRA APIs, just for testing*/
    @GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> checkHealth() {
        return new ResponseEntity<String>("Dukaan is up and Running! Lalit ka laptop order kro", HttpStatus.OK);
    }


}
