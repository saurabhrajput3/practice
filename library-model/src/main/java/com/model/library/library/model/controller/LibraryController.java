package com.model.library.library.model.controller;

import com.model.library.library.model.service.LibraryService;
import org.apache.tomcat.jni.Library;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/library-model")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {

        this.libraryService = libraryService;
    }
    @PostMapping("/add-library/library/l")
    public void addLibrary(Library l){
        libraryService.addLibrary(l);
    }

    @GetMapping("/getbyname/{name}")
    public Library findbyName(@PathVariable String name){

        return libraryService.findbyName(name);
    }

    @GetMapping("/findAll")
    public ArrayList<Library> findAll(){

        return libraryService.findAll();
    }
}
