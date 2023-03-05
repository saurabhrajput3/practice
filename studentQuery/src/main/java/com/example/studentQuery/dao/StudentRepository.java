package com.example.studentQuery.dao;

import com.example.studentQuery.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "Select * from tbl_student where firstname=:firstname and lastname=:lastname",nativeQuery = true)
    public List<Student> findStudentByName(String firstname, String lastname);

    @Query(value = "Select * from tbl_student where age=:age",nativeQuery = true)
    public List<Student> findStudentByAge(int age);

    @Query(value = "Select * from tbl_student where active=true",nativeQuery = true)
    public List<Student> findAllStudent();

    @Query(value = "Select * from tbl_student where active=:active",nativeQuery = true)
    public List<Student> findStudentByActive(boolean active);


}
