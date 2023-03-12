package com.chatapplication.chat.application.controller;

import com.chatapplication.chat.application.dao.StatusRepository;
import com.chatapplication.chat.application.dao.UserRepository;
import com.chatapplication.chat.application.model.Status;
import com.chatapplication.chat.application.model.Users;
import com.chatapplication.chat.application.service.UserService;
import com.chatapplication.chat.application.util.CommonUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value="/api/v1/user")
public class UserController {
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
        @PostMapping(value="/create-user")
        public ResponseEntity<String> createUser(@RequestBody String userData){
            JSONObject isValid= validateUserRequest(userData);

            Users user=null;

            if(isValid.isEmpty()) {
                 user = setUser(userData);
                userService.saveUser(user);
            }
            else{
                return new ResponseEntity<String>(isValid.toString(), HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>("Saved",HttpStatus.CREATED);

        }

        @GetMapping(value = "/get-users")
        public ResponseEntity<String> getUsers(@Nullable @RequestParam String userId){
            JSONArray userArr=userService.getUsers(userId);

            return new ResponseEntity<>(userArr.toString(),HttpStatus.OK);

        }
        @PostMapping(value = "/login")
        public ResponseEntity<String> login(@RequestBody String requestData){
                JSONObject requestJson= new JSONObject(requestData);

                JSONObject isValidLogin= validateLogin(requestJson);

                if(isValidLogin.isEmpty()){
                    String username=requestJson.getString("username");
                    String password=requestJson.getString("password");
                    JSONObject responseObj=userService.login(username,password);
                    if(responseObj.has("errorMessage")){
                        return new ResponseEntity<String>(responseObj.toString(),HttpStatus.BAD_REQUEST);
                    }else{
                        return new ResponseEntity<String>(responseObj.toString(),HttpStatus.OK);
                    }
                }
                else{
                    return new ResponseEntity<String>(isValidLogin.toString(),HttpStatus.BAD_REQUEST);
                }


        }

            @PutMapping(value ="/update-user/{userId}")
            public ResponseEntity<String> updateUser(@PathVariable String userId,@RequestBody String requestData){
                JSONObject isRequestValid= validateUserRequest(requestData);
                Users user=null;

                if(isRequestValid.isEmpty()){
                    user =setUser(requestData);
                    JSONObject responseObj=userService.updateUser(user, userId);
                    if(responseObj.has("errorMessage")){
                        return new ResponseEntity<String>(responseObj.toString(),HttpStatus.BAD_REQUEST);
                    }
                }else{
                    return new ResponseEntity<String>(isRequestValid.toString(),HttpStatus.BAD_REQUEST);
                }
                return new ResponseEntity("user updated",HttpStatus.OK);


            }

            @DeleteMapping(value = "/delete-user/{userId}")
            public ResponseEntity<String> deleteUser(@PathVariable int userId){
            userService.deleteUserByUserId(userId);
            return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
            }








        private JSONObject validateLogin(JSONObject requestJson){
            JSONObject errorList=new JSONObject();

            if(!requestJson.has("username")){
                errorList.put("username","Missing Parameter");
            }
            if(!requestJson.has("password")){
                errorList.put("password","Missing Parameter");
            }
            return errorList;
        }



        private JSONObject validateUserRequest(String userData){
            JSONObject userJson=new JSONObject(userData);
            JSONObject errorList=new JSONObject();

            if(userJson.has("username")){
                if(!userJson.has("isUpdate")) {

                    String username = userJson.getString("username");
                    List<Users> usersList = userRepository.findByUsername(username);
                    if (usersList.size() > 0) {
                        errorList.put("username", "This username is already exists");
                        return errorList;
                    }
                }
            }
            else{
                errorList.put("username","Missing Parameter");
            }
            if(!userJson.has("isUpdate")) {
                if (userJson.has("password")) {
                    String password = userJson.getString("password");
                    if (!CommonUtils.isValidPassword(password)) {
                        errorList.put("password", "Enter valid Password");
                    }
                }
            }
            else{
                errorList.put("password","Missing Parameter");
            }

            if(userJson.has("firstName")){
                String firstName=userJson.getString("firstName");
            }
            else{
                errorList.put("firstName","Missing Parameter");
            }

            if(userJson.has("email")){
                String email=userJson.getString("email");
                if(!CommonUtils.isValidEmail(email)){
                    errorList.put("email","Enter Valid Email");
                }
            }
            else{
                errorList.put("email","Missing Parameter");
            }

            if(userJson.has("phoneNumber")){
                String phoneNumber=userJson.getString("phoneNumber");
                if(!CommonUtils.isValidPhoneNumber(phoneNumber)){
                    errorList.put("phoneNumber","Enter valid phoneNumber");
                }
            }
            else{
                errorList.put("phoneNumber","Missing Parameter");
            }

            if(userJson.has("age")){
                String age=userJson.getString("age");
            }
            if(userJson.has("lastName")){
                String lastName=userJson.getString("lastName");
            }

            return errorList;
        }

        private Users setUser(String userData){
            Users user=new Users();
            JSONObject json=new JSONObject(userData);

            user.setEmail(json.getString("email"));
            user.setPassword(json.getString("password"));
            user.setFirstName(json.getString("firstName"));
            user.setUsername(json.getString("username"));
            user.setPhoneNumber(json.getString("phoneNumber"));

            if(json.has("age")){
                user.setAge(json.getInt("age"));
            }
            if(json.has("lastName")){
                user.setLastName(json.getString("lastName"));
            }
            if(json.has("gender")){
                user.setGender(json.getString("gender"));
            }

            Timestamp createdTime=new Timestamp(System.currentTimeMillis());
            user.setCreatedDate(createdTime);

            Status status=statusRepository.findById(1).get();
            user.setStatusId(status);

            return user;
        }

}
