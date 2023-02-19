# Framework: SpringBoot
# Language: Java

# Data Flow:
## 1) Controller: 
### save Address: 
 @PostMapping(value = "/address")
    public ResponseEntity<String> saveAddress(@RequestBody String address)
                
### save order: 
 @PostMapping(value = "/order")
    public ResponseEntity<String> saveOrder(@RequestBody String order)
                             
### get order:  
 @GetMapping(value = "/getOrder")
    public Order getOrder(@RequestParam Integer orderId)
                  
### save product: 
 @PostMapping(value = "/product")
    public ResponseEntity<String> saveProduct(@RequestBody String product)
                  
### Get Product: 
 @GetMapping(value = "/getProduct")
    public ResponseEntity getProductByCtg(@RequestParam String category)

### get product:  
 @DeleteMapping(value = "/deleteProduct")
    public void getProduct(@RequestParam Integer productId)

### save user:
 @PostMapping(value = "/user")
    public ResponseEntity<String> saveUser(@RequestBody String user)

### get user: 
 @GetMapping(value = "/getUser")
    public User getUser(@RequestParam Integer userId)


                        

