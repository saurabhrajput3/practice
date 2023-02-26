# Framework: SpringBoot
# Language: Java

# Data Flow:
## 1) Controller: 
### add Book: 
    @PostMapping
        public Book addBook(@RequestBody Book book)
        
### get Book: 
  @GetMapping("/{bookId}")
        public Book getBook(@PathVariable String bookId) 
                             
### get all book:  
   @GetMapping
        public List<Book> getAllBook()
                  
### get all book b studentid: 
   @GetMapping("/student/{studentID}")
        public List<Book> getAllBook(@PathVariable(value = "studentID") String studentID)
                  
### add course: 
 @PostMapping
    public Course addCourse(@RequestBody Course course)

### get course:  
  @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable String courseId)

### add laptop:
   @PostMapping
    public Laptop addLaptop(@RequestBody Laptop laptop) 

### get all laptop: 
   @GetMapping("/{laptopId}")
    public Laptop getLaptop(@PathVariable String laptopId) 
 
 
 ## 2) Service:
 
 ### save user:
  public void saveUser(User user)
 
 ### get User:
  public User getUser(Integer id)
 
 
### save product:
  public void saveProduct(Product product)
 
 ### get product:
    public JSONArray getProduct(String category)
 
 ### delete product:
   public void deleteProduct(Integer productId)
 
 ### save product:
  public void saveOrder(Order o)
 
 ### get order:
   public Order getOrder(Integer orderId)
 
 ### save address:
  public void saveAddress(Address a)
 
 


                        

