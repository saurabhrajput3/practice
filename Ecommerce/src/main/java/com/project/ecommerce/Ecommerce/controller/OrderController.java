package com.project.ecommerce.Ecommerce.controller;

import com.project.ecommerce.Ecommerce.dao.AddressRepository;
import com.project.ecommerce.Ecommerce.dao.OrderRepository;
import com.project.ecommerce.Ecommerce.dao.ProductRepository;
import com.project.ecommerce.Ecommerce.dao.UserRepository;
import com.project.ecommerce.Ecommerce.model.Address;
import com.project.ecommerce.Ecommerce.model.Order;
import com.project.ecommerce.Ecommerce.model.Product;
import com.project.ecommerce.Ecommerce.model.User;
import com.project.ecommerce.Ecommerce.service.OrderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/order")
    public ResponseEntity<String> saveOrder(@RequestBody String order){
        JSONObject json = new JSONObject(order);
        Order o=setOrder(json);
        orderService.saveOrder(o);
        return new ResponseEntity<>("Order saved", HttpStatus.CREATED);

    }
    @GetMapping(value = "/getOrder")
    public Order getOrder(@RequestParam Integer orderId){
        return orderService.getOrder(orderId);
    }


    private Order setOrder(JSONObject json) {
        Order or=new Order();
        or.setId(json.getInt("id"));
        or.setProductQuantity(json.getInt("productQuantity"));

        String ui = json.getString("Id");
        User user = userRepository.findById(Integer.valueOf(ui)).get();
        or.setUser(user);

        String pi = json.getString("id");
        Product product = productRepository.findById(Integer.valueOf(pi)).get();
        or.setProduct(product);



        String ai = json.getString("id");
        Address address = addressRepository.findById(Integer.valueOf(ai)).get();
        or.setAddress(address);


        return or;
    }
}
