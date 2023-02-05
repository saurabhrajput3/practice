package com.restaurant.project.RestaurantModel.service;

import com.restaurant.project.RestaurantModel.model.Resturant;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;
@Service
public class ResturantService {

    private static HashMap<String, Resturant> hm=new HashMap<>();

    static{
        hm.put("palace",new Resturant("palace","chikhli road,buldhana","8878557885","Desi taste",35,"9-24"));
        hm.put("maharaja",new Resturant("maharaja","chikhli road,buldhana","7877747858","North indian",22,"5-24"));
        hm.put("magic",new Resturant("magic","main road,buldhana","8785542585","south indian",12,"7-24"));
        hm.put("royalSpot",new Resturant("royalSpot","main road,buldhana","9968996856","Veg indian",45,"9-24"));
        hm.put("urbangarden",new Resturant("urbangarden","urban road,buldhana","7854742585","Veg thaliMix",12,"12-24"));
        hm.put("tophill",new Resturant("tophill","climax road,buldhana","7854542585","Kokani",12,"3-24"));
    }

    public HashMap<String,Resturant> findAll(){
        return hm;
    }
    public Resturant findbyName(String n){
        return hm.get(n);
    }

    public void addResturant(String s,Resturant r){
        hm.put(s,r);
    }

    public void deleteResturant(String s){
        hm.remove(s);
    }


}
