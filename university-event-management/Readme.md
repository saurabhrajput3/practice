##Framework: SpringBoot
##Language: Java

Data Flow:
1) Controller: 
Add student:  @PostMapping("/addStudent/id/{id}")
             public void addStudent(@PathVariable String id, @RequestBody Student s)
                
update student department:  @PutMapping("/updateStudentDepartment/id/{id}")
                             public void updateDepartment(@PathVariable String id,@RequestBody String d)
                             
delete student:   @DeleteMapping("/deleteStudentinfo/id/{id}")
                  public void deleteStudent(@PathVariable String id)
                  
Get all students: @GetMapping("/getAllStudent")
                  public HashMap<String, Student> getAllStudent()
                  
Get student by Id: @GetMapping("/getStudentbyId/id/{id}")
                    public Student getStudentbyId(@PathVariable String id)

Add event:  @PostMapping("/addEvent/id/{id}")
            public void addEvent(@PathVariable String id, @RequestBody Event e)

Update event:  @PutMapping("/updateEvent/id/{id}")
                public void updateEvent(@PathVariable String id,@RequestBody Event e)

Delete event:   @DeleteMapping("/deleteEvent/id/{id}")
                 public void deleteEvent(@PathVariable Event e)

Get All event by date: @GetMapping("/getAllEventbyDate/date/{d}")
                        public HashMap<String, Event> getAll(@PathVariable String d)
                        

2) Service: Created two hashmap one for student details and another one for event details

This project is for University Event Management
