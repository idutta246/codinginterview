package com.interview_coding.orderapi.services;

import com.interview_coding.orderapi.model.Order;
import com.interview_coding.orderapi.model.UseOrder;

import java.util.List;

public interface OrderService {

    List<UseOrder> getAllOrders();

    UseOrder getOrderById(int orderId);

    UseOrder addNewOrder(UseOrder useOrder);
}
