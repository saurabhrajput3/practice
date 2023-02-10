package com.model.library.library.model.service;

import com.model.library.library.model.model.library;
import org.apache.tomcat.jni.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
@Service
public class LibraryService {
    static ArrayList<library> al=new ArrayList<>();

    static {
        al.add(new library("star","buldhana","98885478854","wifi"));
        al.add(new library("magiclibrary","pune","558745896","wifi"));
        al.add(new library("hiton","mumbai","7785448554","Nowifi"));
        al.add(new library("flex","delhi","77885544556","wifi"));
        al.add(new library("joy","nagpur","88548885547","Nowifi"));
    }

    public void addLibrary(Library l) {
        al.add(l);
    }

    public library findbyName(String name){
        for(library e:al){
            if(e[0].equals(name)){
                return e;
            }
        }
        return null;
    }

    public ArrayList<library> findAll(){

        return al;
    }
}
