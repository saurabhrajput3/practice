package com.portal.studentinfo.studentinfo.service;

import com.portal.studentinfo.studentinfo.dao.BookRepository;
import com.portal.studentinfo.studentinfo.model.Book;
import com.portal.studentinfo.studentinfo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private StudentService studentService;

    public Book addBook(Book bookDto)  {
        String ID = UUID.randomUUID().toString();

        Student byStudent = studentService.findByStudent(bookDto.getStudentID());
        Book book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setPrice(bookDto.getPrice());
        book.setStudent(byStudent);
        book.setDescription(book.getDescription());
        book.setID(ID);
        Book __book = bookRepo.save(book);
        return __book;
    }

    public List<Book> findAllBookByStudentId(String studentID) {
        Student byStudent = studentService.findByStudent(studentID);
        List<Book> allBookByStudent = bookRepo.findAllBookByStudent(byStudent);
        for(Book b:allBookByStudent){
            b.setStudent(null);
        }
        return allBookByStudent;
    }


    public Book findByBook(String bookId)  {
        Optional<Book> bookOptional = bookRepo.findById(bookId);

        if(bookOptional.isPresent())
            return bookOptional.get();


    }

    public List<Book> findAllBook() {
        List<Book> bookRepoAll = bookRepo.findAll();
        return bookRepoAll;
    }
}
