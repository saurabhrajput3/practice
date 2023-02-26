package com.portal.studentinfo.studentinfo.controller;

import com.portal.studentinfo.studentinfo.model.Course;
import com.portal.studentinfo.studentinfo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course addCourse(@RequestBody Course course){
        Course __course =  courseService.addCourse(course);
        return __course;
    }



    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        Course __course  = courseService.findByCourse(courseId);
        return __course;
    }


    @GetMapping
    public List<Course> getAllCourse(){
        List<Course> allCourse = courseService.findAllCourse();
        return allCourse;
    }

    @PostMapping("course/student/add")
    public String addStudentToCourse(@RequestParam(value = "studentId",required = true)String studentId,
                                     @RequestParam(value="courseId",required = true)String courseId)  {
        this.courseService.addStudentToCourse(studentId,courseId);
        return "student added to course";
    }
}
