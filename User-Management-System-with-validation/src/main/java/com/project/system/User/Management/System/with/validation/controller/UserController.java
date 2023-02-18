package com.project.system.User.Management.System.with.validation.controller;

import com.project.system.User.Management.System.with.validation.model.User;
import com.project.system.User.Management.System.with.validation.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value="/add-user/id/{id}")
    public ResponseEntity<String> addUser(@RequestBody String requestUser) {

        JSONObject json = new JSONObject(requestUser);

        List<String> validationList = validateUser(json);

        if(validationList.isEmpty()) {
            User user = setUser(json);
            userService.addUser(user);
            return new ResponseEntity<>("User saved", HttpStatus.CREATED);
        } else {

            String[] answer = Arrays.copyOf(
                    validationList.toArray(), validationList.size(), String[].class);

            return new ResponseEntity<>("Please pass these mandatory parameters- " +
                    Arrays.toString(answer), HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/getUser")
    public User getUserbyID(@RequestParam String userid){

        return userService.getUserbyID(userid);
    }
    @GetMapping("/getAllUser")
    public ResponseEntity getAllUser(){

        List<User> userDetails= userService.getAllUser();
        return new ResponseEntity<>(userDetails.toString(), HttpStatus.OK);
    }

    @PutMapping("/updateUserInfo")
    public void updateUser(@RequestBody User user){

        userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@PathVariable String id){

        userService.deleteUser(id);
    }

    private List<String> validateUser(JSONObject json) {

        List<String> errorList = new ArrayList<>();

        if(!json.has("UserName")) {
            errorList.add("UserName");
        }

        if(json.has("DateOfBirth")) {
        String date =json.getString("DateOfBirth");
           for(int i=0;i<date.length();i++){
               if(date.charAt(2)!='-'&&date.charAt(5)!='-'){
                   errorList.add("DateOfBirth");
               }
           }
        }else{
            errorList.add("DateOfBirth");
        }

        if(!json.has("email")) {
            errorList.add("email");
        }

        if(json.has("PhoneNumber")) {
            String pn= json.getString("PhoneNumber");
            if(pn.length()!=12) {
                errorList.add("PhoneNumber");
            }
        }else{
            errorList.add("PhoneNumber");
        }


        return errorList;

    }

    public User setUser (JSONObject json) {
        User user = new User();

        String UserId =  json.getString("UserId");
        user.setUserId(UserId);

        String DateOfBirth = json.getString("DateOfBirth");
        user.setDateOfBirth(DateOfBirth);

        String UserName = json.getString("UserName");
        user.setUserName(UserName);

        String email = json.getString("email");
        user.setEmail(email);


        String PhoneNumber = json.getString("PhoneNumber");
        user.setPhoneNumber(PhoneNumber);

        String date = json.getString("date");
        user.setDate(date);

        String time = json.getString("time");
        user.setTime(time);

        return user;

    }

}
