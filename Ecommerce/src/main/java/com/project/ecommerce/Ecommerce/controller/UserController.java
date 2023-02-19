package com.project.ecommerce.Ecommerce.controller;

import com.project.ecommerce.Ecommerce.model.User;
import com.project.ecommerce.Ecommerce.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping(value = "/user")
    public ResponseEntity<String> saveUser(@RequestBody String user){
        JSONObject json = new JSONObject(user);
        User u=setUser(json);
        userService.saveUser(u);
        return new ResponseEntity<>("User saved", HttpStatus.CREATED);

    }
    @GetMapping(value = "/getUser")
    public User getUser(@RequestParam Integer userId){
        return userService.getUser(userId);
    }






    private User setUser(JSONObject json) {
        User us=new User();
        us.setId(json.getInt("Id"));
        us.setName(json.getString("name"));
        us.setEmail(json.getString("email"));
        us.setPassword(json.getString("password"));
        us.setPhoneNumber(json.getString("phoneNumber"));
return us;
    }
}
