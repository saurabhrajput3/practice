# Framework: SpringBoot
# Language: Java

# Data Flow:
## 1) Controller: 
### create post: 
 @PostMapping(value = "/post")
    public ResponseEntity<String> savePost(@RequestBody String postRequest) 
                
### get post by userid or post id: 
  @GetMapping(value = "/post")
    public ResponseEntity<String> getPost(@RequestParam String userId, @Nullable @RequestParam String postId)
                             
### update post:  
  @PutMapping(value = "/post/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable String postId, @RequestBody String postRequest)
                  
### create user: 
@PostMapping(value = "/user-create")
    public ResponseEntity saveUser(@RequestBody String userData)
   
                  
### get user: 
 @GetMapping(value = "/user")
    public ResponseEntity<String> getUser(@Nullable @RequestParam String userId)

### update user by userid:  
 @PutMapping(value = "/user/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable String userId, @RequestBody String userData)

 
 
 ## 2) Service:
 
 ### save user:
  public int saveUser(User user)
  
 ### update user:
  public void updateUser(User newUser, String userId)  
