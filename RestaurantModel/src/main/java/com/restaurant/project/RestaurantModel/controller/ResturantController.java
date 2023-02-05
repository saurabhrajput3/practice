package com.restaurant.project.RestaurantModel.controller;

import com.restaurant.project.RestaurantModel.service.ResturantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.restaurant.project.RestaurantModel.model.Resturant;

import java.util.HashMap;

@RestController
@RequestMapping("/RestaurantModel")
public class ResturantController {

    private final ResturantService resturantService;

    public ResturantController(ResturantService resturantService){
        this.resturantService=resturantService;
    }

@PostMapping("/addResturant")
    public void addResturant(@RequestBody String n, Resturant r){
        resturantService.addResturant(n,r);
    }
@GetMapping("/findbyName/name/{n}")
    public Resturant findbyName(@PathVariable String n){
        return resturantService.findbyName(n);
    }
@GetMapping("/findAll")
    public HashMap<String,Resturant> findAll(){
        return resturantService.findAll();
    }
@DeleteMapping("/deleteResturant/name/{n}")
    public void deleteResturant(@PathVariable String n){
        resturantService.deleteResturant(n);
    }

}
