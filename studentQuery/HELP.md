# Framework: SpringBoot
# Language: Java

# Data Flow:
## 1) Controller: 
### create student: 
 @PostMapping(value = "/create-student")
    public ResponseEntity<String> createStudent(@RequestBody String s)
                
### get student by name: 
  @GetMapping(value="/get-student-by-name")
    public ResponseEntity<String> getStudentByName(@RequestParam String first, @RequestParam String last)
                             
### get student by age:  
 @GetMapping(value="/get-student-by-Age")
    public ResponseEntity<String> getStudentByAge(@RequestParam int age)
                  
### get student by active: 
 @GetMapping(value="/get-student-by-Active")
    public ResponseEntity<String> getStudentByActive(@RequestParam boolean active)
                  
### get all student: 
 public ResponseEntity<String> getAllStudent(){
        JSONArray studentArray=studentService.getAllStudent()

### delete student by age:  
 @DeleteMapping(value="/delete-student-by-age")
    public ResponseEntity<String> deleteStudent(@PathVariable int age)

 
 
 ## 2) Service:
 
 ### save student:
  public void saveStudent(Student student)
 
 ### get student by name:
 public JSONArray getStudentByName(String first, String last)
 
 
### get student by age:
  public JSONArray getStudentByAge(int age)
 
 ### get student by active:
  public JSONArray getStudentByActive(boolean active)
 
 ### get all student:
    public JSONArray getAllStudent()
 
 ### delete student by age:
   public void deleteStudentByAge(int age)
 
