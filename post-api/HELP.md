# Framework: SpringBoot
# Language: Java

# Data Flow:
## 1) Controller: 
### create post: 
@PostMapping(value = "/create-post")
    public ResponseEntity<String> createPost(@RequestBody String bodyPost)
  
### get all post: 
  @GetMapping(value = "/get-all-post")
    public ResponseEntity<String> getAllPost()
                

 
 ## 2) Service:
 
 ### save post:
   public void save(Post post)
 
 ### get all post :
  public JSONArray getAll() 
 

 ## 3) Repo:
  ### get all post
   @Query(value = "select * from tbl_post",nativeQuery = true)
    public List<Post> findAll();
