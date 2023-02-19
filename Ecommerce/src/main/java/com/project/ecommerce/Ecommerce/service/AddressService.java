package com.project.ecommerce.Ecommerce.service;

import com.project.ecommerce.Ecommerce.dao.AddressRepository;
import com.project.ecommerce.Ecommerce.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public void saveAddress(Address a){
        addressRepository.save(a);
    }
}
