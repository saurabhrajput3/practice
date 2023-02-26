package com.portal.studentinfo.studentinfo.dao;

import com.portal.studentinfo.studentinfo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,String> {
}
