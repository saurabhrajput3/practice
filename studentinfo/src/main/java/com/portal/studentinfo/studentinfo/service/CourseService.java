package com.portal.studentinfo.studentinfo.service;

import com.portal.studentinfo.studentinfo.dao.CourseRepository;
import com.portal.studentinfo.studentinfo.dao.StudentRepository;
import com.portal.studentinfo.studentinfo.model.Course;
import com.portal.studentinfo.studentinfo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CourseService {
    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepo;

    public Course addCourse(Course courseDto) {
        String ID = UUID.randomUUID().toString();

        Course course = new Course();
        course.setID(ID);
        course.setTitle(courseDto.getTitle());
        course.setDuration(courseDto.getDuration());
        course.setDescription(courseDto.getDescription());
        Course __course = courseRepo.save(course);
        return __course;
    }

    public Course findByCourse(String courseId)  {
        Optional<Course> courseOptional = courseRepo.findById(courseId);


            return courseOptional.get();


    }

    public List<Course> findAllCourse() {
        List<Course> courseRepoAll = courseRepo.findAll();
        return courseRepoAll;
    }


    public void addStudentToCourse(String studentId, String courseId)  {
        Optional<Course> optionalCourse = this.courseRepo.findById(courseId);


        if(optionalCourse.isPresent()){
            Student student = this.studentService.findByStudent(studentId);

            Course course = optionalCourse.get();
            List<Student> studentList = course.getStudentList();
            studentList.add(student);
            courseRepo.save(course);

        }

    }
}
