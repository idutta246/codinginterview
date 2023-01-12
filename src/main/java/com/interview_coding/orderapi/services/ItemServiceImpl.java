package com.interview_coding.orderapi.services;

import com.interview_coding.orderapi.dao.ItemRepository;
import com.interview_coding.orderapi.model.Item;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional
    public Item addItem(Item item) {
        return this.itemRepository.save(item);
    }

    @Override
    @Transactional
    public Item getItem(int itemId) {
        return this.itemRepository.findById(itemId).get();
    }
}
