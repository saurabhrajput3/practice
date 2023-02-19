package com.project.ecommerce.Ecommerce.service;

import com.project.ecommerce.Ecommerce.dao.UserRepository;
import com.project.ecommerce.Ecommerce.model.User;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public void saveUser(User user) {
        repository.save(user);
    }

    public User getUser(Integer id){
        return repository.getReferenceById(id);
    }

}
