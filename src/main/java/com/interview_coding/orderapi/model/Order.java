package com.interview_coding.orderapi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="myorder")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="orderId")
    private int orderId;

    @Column(name="orderDate")
    private String orderDate;

    @Column(name="orderStatus")
    private String orderStatus;

    @Column(name="itemCollection")
    private String itemCollection;



    public Order() {
    }

    public Order(int orderId, String orderDate, String orderStatus, String itemCollection) {
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

    public String getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(String itemCollection) {
        this.itemCollection = itemCollection;
    }

}
