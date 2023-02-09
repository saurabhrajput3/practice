package com.manage.user.UserManagementSystem.controller;

import com.manage.user.UserManagementSystem.model.User;
import com.manage.user.UserManagementSystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/user-manage/system")
public class UserController {
private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }
    @PostMapping("/add-user/id/{id}")
    public void addUser(@PathVariable String id, @RequestBody User user){

        userService.addUser(id,user);
    }

    @GetMapping("/getUser/{userid}")
    public User findUserbyID(@PathVariable String userid){

        return userService.findbyID(userid);
    }

    @GetMapping("/findAll")
    public HashMap<String,User> findAllUser(){

        return userService.findAll();
    }

@PutMapping("/updateUserInfo/id/{id}")
public void updateUser(@PathVariable String id,@RequestBody User user){

        userService.updateUser(id,user);
}

@DeleteMapping("/deleteUser/id/{id}")
public void deleteUser(@PathVariable String id){

        userService.deleteUser(id);
}

}
