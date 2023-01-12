package com.interview_coding.orderapi.controller;

import com.interview_coding.orderapi.model.Order;
import com.interview_coding.orderapi.model.UseOrder;
import com.interview_coding.orderapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<UseOrder> getAllOrders()
    {
        return this.orderService.getAllOrders();
    }

    @GetMapping("/order/{orderId}")
    public UseOrder getOrderById(@PathVariable int orderId)
    {
        return this.orderService.getOrderById(orderId);
    }

    @PostMapping("/order/create")
    public UseOrder addNewOrder(@RequestBody UseOrder useOrder)
    {
        return this.orderService.addNewOrder(useOrder);
    }
}
