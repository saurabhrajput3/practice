package com.example.studentQuery.controller;

import com.example.studentQuery.model.Student;
import com.example.studentQuery.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.json.JSONArray;
import org.json.JSONObject;

@RestController
@RequestMapping(value="/query")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping(value = "/create-student")
    public ResponseEntity<String> createStudent(@RequestBody String s){
        Student student=null;

        student=setStudent(s);
        studentService.saveStudent(student);

        return new ResponseEntity<>("Saved", HttpStatus.CREATED);

    }
    @GetMapping(value="/get-student-by-name")
    public ResponseEntity<String> getStudentByName(@RequestParam String first, @RequestParam String last){
        JSONArray studentArray=studentService.getStudentByName(first,last);
        return new ResponseEntity<>(studentArray.toString(),HttpStatus.OK);
    }

    @GetMapping(value="/get-student-by-Age")
    public ResponseEntity<String> getStudentByAge(@RequestParam int age){
        JSONArray studentArray=studentService.getStudentByAge(age);
        return new ResponseEntity<>(studentArray.toString(),HttpStatus.OK);
    }

    @GetMapping(value="/get-student-by-Active")
    public ResponseEntity<String> getStudentByActive(@RequestParam boolean active){
        JSONArray studentArray=studentService.getStudentByActive(active);
        return new ResponseEntity<>(studentArray.toString(),HttpStatus.OK);
    }

    @GetMapping(value="/get-allStudent")
    public ResponseEntity<String> getAllStudent(){
        JSONArray studentArray=studentService.getAllStudent();
        return new ResponseEntity<>(studentArray.toString(),HttpStatus.OK);
    }

    @DeleteMapping(value="/delete-student-by-age")
    public ResponseEntity<String> deleteStudent(@PathVariable int age){
        studentService.deleteStudentByAge(age);
        return new ResponseEntity<>("Deleted",HttpStatus.NO_CONTENT);
    }













    private Student setStudent(String s){
        Student student=new Student();
        JSONObject json=new JSONObject(s);
        student.setId((json.getString("Id")));
        student.setFirstName(json.getString("firstName"));
        student.setLastName(json.getString("lastName"));
        student.setAge(json.getInt("age"));
        student.setActive(json.getBoolean("active"));
        student.setAdmissionDate(json.getString("admissionDate"));

        return student;

    }


}