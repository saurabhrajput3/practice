package com.portal.studentinfo.studentinfo.controller;

import com.portal.studentinfo.studentinfo.model.Student;
import com.portal.studentinfo.studentinfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        Student __student =  studentService.addStudent(student);
        return __student;
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable String studentId)  {
        Student __student  = studentService.findByStudent(studentId);
        return __student;
    }


    @GetMapping
    public List<Student> getAllStudent(){
        List<Student> allStudent = studentService.findAllStudent();
        return allStudent;
    }
}
