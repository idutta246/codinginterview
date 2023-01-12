package com.interview_coding.orderapi.model;

import jakarta.persistence.*;

@Entity
@Table(name="myitems")
public class Item {

    @Column(name="orderId")
    private int orderId;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="itemId")
    private int itemId;

    @Column(name="itemName")
    private String itemName;

    @Column(name="itemUnitPrice")
    private String itemUnitPrice;

    @Column(name="itemQuantity")
    private int itemQuantity;

    public Item() {
    }

    public Item(int orderId, int itemId, String itemName, String itemUnitPrice, int itemQuantity) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemUnitPrice = itemUnitPrice;
        this.itemQuantity = itemQuantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUnitPrice() {
        return itemUnitPrice;
    }

    public void setItemUnitPrice(String itemUnitPrice) {
        this.itemUnitPrice = itemUnitPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

}
