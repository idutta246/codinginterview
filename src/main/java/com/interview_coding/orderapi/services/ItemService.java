package com.interview_coding.orderapi.services;

import com.interview_coding.orderapi.model.Item;

import java.util.List;

public interface ItemService {

    public Item addItem(Item item);

    public Item getItem(int itemId);
}
