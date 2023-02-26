package com.portal.studentinfo.studentinfo.dao;

import com.portal.studentinfo.studentinfo.model.Book;
import com.portal.studentinfo.studentinfo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {
    List<Book> findAllBookByStudent(Student student);
}
