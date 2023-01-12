package com.interview_coding.orderapi.services;

import com.interview_coding.orderapi.dao.OrderRepository;
import com.interview_coding.orderapi.model.Item;
import com.interview_coding.orderapi.model.Order;
import com.interview_coding.orderapi.model.UseOrder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemService itemService;

    @Override
    @Transactional
    public List<UseOrder> getAllOrders()
    {
        List<Order> orderList = this.orderRepository.findAll();
        List<UseOrder> useOrderList = null;

        for(int i = 0; i < orderList.size(); i++ )
        {
            String itemids = orderList.get(i).getItemCollection();
            String[] itemIdList = itemids.split(",");
            List<Item> items = null;

            for(int j = 0; j< itemIdList.length; j++)
            {
                items.add(this.itemService.getItem(Integer.parseInt(itemIdList[j])));
            }

            UseOrder newUseOrder = new UseOrder(orderList.get(i).getOrderId(), orderList.get(i).getOrderDate(), orderList.get(i).getOrderStatus(), items);

            useOrderList.add(newUseOrder);
        }

        return useOrderList;
    }

    @Override
    @Transactional
    public UseOrder addNewOrder(UseOrder useOrder)
    {
        String itemIdCollection = "";

        for(int i = 0; i < useOrder.getItemCollection().size(); i++)
        {
            itemIdCollection = itemIdCollection + ',' + useOrder.getItemCollection().get(i).getOrderId();
        }

        Order newOrder = new Order(useOrder.getOrderId(), useOrder.getOrderDate(), useOrder.getOrderStatus(), itemIdCollection);

        this.orderRepository.save(newOrder);

        for(int i = 0; i < useOrder.getItemCollection().size(); i++)
        {
            this.itemService.addItem(useOrder.getItemCollection().get(i));
        }

        return useOrder;
    }

    @Override
    @Transactional
    public UseOrder getOrderById(int orderId)
    {
        UseOrder foundUseOrder = new UseOrder();

        Order foundOrder = this.orderRepository.findById(orderId).get();

        String itemids = foundOrder.getItemCollection();
        String[] itemIdList = itemids.split(",");
        List<Item> items = null;

        for(int j = 0; j< itemIdList.length; j++)
        {
            items.add(this.itemService.getItem(Integer.parseInt(itemIdList[j])));
        }

        foundUseOrder = new UseOrder(foundOrder.getOrderId(), foundOrder.getOrderDate(), foundOrder.getOrderStatus(), items);

        return foundUseOrder;

    }
}
