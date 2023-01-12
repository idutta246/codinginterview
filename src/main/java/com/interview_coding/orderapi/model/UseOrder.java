package com.interview_coding.orderapi.model;

import jakarta.persistence.Column;

import java.util.List;

public class UseOrder {
    private int orderId;

    @Column(name="orderDate")
    private String orderDate;

    @Column(name="orderStatus")
    private String orderStatus;

    @Column(name="itemCollection")
    private List<Item> itemCollection;

    public UseOrder() {
    }

    public UseOrder(int orderId, String orderDate, String orderStatus, List<Item> itemCollection) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.itemCollection = itemCollection;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(List<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }
}
