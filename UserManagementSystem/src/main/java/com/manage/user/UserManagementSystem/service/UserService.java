package com.manage.user.UserManagementSystem.service;
import com.manage.user.UserManagementSystem.service.UserService;
import com.manage.user.UserManagementSystem.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
@Service
public class UserService {

    static HashMap<String, User> hm=new HashMap<>();

    static {
        hm.put("abc1",new User("abc1","abc","abc@gmail.com","buldhana","8857996575"));
        hm.put("def2",new User("def2","def","def@gmail.com","chikhli","7554875547"));
        hm.put("ghi3",new User("ghi3","ghi","ghi@gmail.com","pune","5477785478"));
        hm.put("hlm4",new User("hlm4","hlm","hlm@gmail.com","nagpur","8855547854"));
        hm.put("sop5",new User("sop5","sop","sop@gmail.com","nashik","8777755854"));
    }


    public void addUser(String id,User user) {
        hm.put(id,user);
    }

    public User findbyID(String userid){
      return hm.get(userid);
    }

    public HashMap<String,User> findAll(){
        return hm;
    }

    public void updateUser(String id, User user) {
        hm.put(id,user);
    }


    public void deleteUser(String id) {
        hm.remove(id);
    }
}
