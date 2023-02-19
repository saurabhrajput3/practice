package com.project.ecommerce.Ecommerce.controller;

import com.project.ecommerce.Ecommerce.dao.UserRepository;
import com.project.ecommerce.Ecommerce.model.Address;
import com.project.ecommerce.Ecommerce.model.User;
import com.project.ecommerce.Ecommerce.service.AddressService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/address")
    public ResponseEntity<String> saveAddress(@RequestBody String address){
        JSONObject json = new JSONObject(address);
        Address a=setAddress(json);
        addressService.saveAddress(a);
        return new ResponseEntity<>("Address saved", HttpStatus.CREATED);

    }


    private Address setAddress(JSONObject json) {
        Address ad=new Address();
        ad.setId(json.getInt("id"));
        ad.setName(json.getString("name"));
        ad.setLandmark(json.getString("landmark"));
        ad.setPhoneNumber(json.getString("phoneNumber"));
        ad.setZipcode(json.getString("zipcode"));
        ad.setState(json.getString("state"));

        String i = json.getString("Id");
        User user = userRepository.findById(Integer.valueOf(i)).get();
        ad.setUser(user);

        return ad;
    }
}
