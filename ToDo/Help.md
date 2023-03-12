# Framework: SpringBoot
# Language: Java

# Data Flow:
## 1) Controller: 
### create user: 
 @PostMapping("/user")
    public String saveUser(@RequestBody User user)
    
### get user: 
     @GetMapping("/user")
    public String getUser(@Nullable @RequestParam String userId)
                             
### update user by userid:  
 @PutMapping("/user/{userId}")
    public String updateUser(@RequestBody User user, @PathVariable String userId)
                  
### delete user by userid: 
  @DeleteMapping("user/{userId}")
    public String deleteUser(@PathVariable Integer userId)
                  
### get book by bookid: 
 @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable String id)

### save book:  
 @PostMapping("/book")
    public String saveBook(@RequestBody Book book)

 
 
 ## 2) Service:
 
 ### save user:
  public String saveUser(User user)
 
 ### get user:
     public List<User> getUser(Integer userId) 
 
 
### update user:
   public String updateUser(User newUserData, Integer userId)
 
 
