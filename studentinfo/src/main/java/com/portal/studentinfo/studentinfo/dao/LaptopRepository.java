package com.portal.studentinfo.studentinfo.dao;

import com.portal.studentinfo.studentinfo.model.Course;
import com.portal.studentinfo.studentinfo.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop,String> {
}
