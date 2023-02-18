package com.project.system.User.Management.System.with.validation.service;

import com.project.system.User.Management.System.with.validation.dao.UserRepository;
import com.project.system.User.Management.System.with.validation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public void addUser(User user) {
      repository.save(user);
    }

    public User getUserbyID(String id){
        return repository.getReferenceById(Integer.parseInt(id));
    }

    public List<User> getAllUser(){
        return repository.findAll();
    }

}
