package com.portal.studentinfo.studentinfo.controller;

import com.portal.studentinfo.studentinfo.model.Book;
import com.portal.studentinfo.studentinfo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {


        @Autowired
        private BookService bookService;

        @PostMapping
        public Book addBook(@RequestBody Book book){
            Book __book =  bookService.addBook(book);
            return __book;
        }

        @GetMapping("/{bookId}")
        public Book getBook(@PathVariable String bookId) {
            Book __book  = bookService.findByBook(bookId);
            return __book;
        }


        @GetMapping
        public List<Book> getAllBook(){
            List<Book> allBook = bookService.findAllBook();
            return allBook;
        }

        @GetMapping("/student/{studentID}")
        public List<Book> getAllBook(@PathVariable(value = "studentID") String studentID) {
            List<Book> allBook = bookService.findAllBookByStudentId(studentID);
            return allBook;
        }


}
