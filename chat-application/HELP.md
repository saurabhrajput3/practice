# Framework: SpringBoot
# Language: Java

# Data Flow:
## 1) Controller: 
### create user: 
  @PostMapping(value="/create-user")
        public ResponseEntity<String> createUser(@RequestBody String userData)
    
### get user by userid: 
     @GetMapping(value = "/get-users")
        public ResponseEntity<String> getUsers(@Nullable @RequestParam String userId)
                             
### login:  
@PostMapping(value = "/login")
        public ResponseEntity<String> login(@RequestBody String requestData)
                  
### update user by userid: 
 @PutMapping(value ="/update-user/{userId}")
            public ResponseEntity<String> updateUser(@PathVariable String userId,@RequestBody String requestData)
                  
###  user user by userid: 
 @DeleteMapping(value = "/delete-user/{userId}")
            public ResponseEntity<String> deleteUser(@PathVariable int userId)

### create status:  
  @PostMapping("/create-status")
    public ResponseEntity<String> createStatus(@RequestBody String statusData)

 
 
 ## 2) Service:
 
 ### save user:
  public int saveUser(Users user)
 
 ### get user:
    public JSONArray getUsers(String userId)
 
 
### update user:
  public JSONObject updateUser(Users newUser,String userId)
 
 
