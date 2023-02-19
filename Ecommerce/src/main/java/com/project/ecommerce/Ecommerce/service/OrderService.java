package com.project.ecommerce.Ecommerce.service;

import com.project.ecommerce.Ecommerce.dao.OrderRepository;
import com.project.ecommerce.Ecommerce.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderService {
    @Autowired
    OrderRepository orderRepository;


    public void saveOrder(Order o){
        orderRepository.save(o);
    }

    public Order getOrder(Integer orderId){
        return orderRepository.getReferenceById(orderId);
    }


}
