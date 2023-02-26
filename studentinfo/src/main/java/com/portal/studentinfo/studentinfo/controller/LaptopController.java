package com.portal.studentinfo.studentinfo.controller;

import com.portal.studentinfo.studentinfo.model.Laptop;
import com.portal.studentinfo.studentinfo.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class LaptopController {


    @Autowired
    private LaptopService laptopService;

    @PostMapping
    public Laptop addLaptop(@RequestBody Laptop laptop) {
        Laptop __laptop =  laptopService.addLaptop(laptop);
        return __laptop;
    }

    @GetMapping("/{laptopId}")
    public Laptop getLaptop(@PathVariable String laptopId) {
        Laptop __laptop  = laptopService.findByLaptop(laptopId);
        return __laptop;
    }


    @GetMapping
    public List<Laptop> getAllLaptop(){
        List<Laptop> allLaptop = laptopService.findAllLaptop();
        return allLaptop;
    }
}
