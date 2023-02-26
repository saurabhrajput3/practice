package com.portal.studentinfo.studentinfo.dao;

import com.portal.studentinfo.studentinfo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {
}
