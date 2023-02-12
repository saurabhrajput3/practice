package com.event.management.universityeventmanagement.service;

import com.event.management.universityeventmanagement.model.Event;
import com.event.management.universityeventmanagement.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class EventService {

    static HashMap<String, Event> hm1=new HashMap<>();

    static {
        hm1.put("sha1",new Event("sha1","shaun","pune","12-2-22","02:00","04:00"));
        hm1.put("cooper22",new Event("cooper22","cooper","mumbai","1-1-23","12:00","15:00"));
        hm1.put("fun4u",new Event("fun4u","funtoos","dubai","6-8-22","16:22","18:00"));
        hm1.put("da2do",new Event("da2do","do&do","sydney","3-3-25","05:30","08:00"));
        hm1.put("fit2fit",new Event("fit2fit","fitnfit","venice","5-12-22","04:20","07:00"));
    }

    static HashMap<String, Student> hm2=new HashMap<>();

    static {
        hm2.put("sumit22",new Student("sumit22","sumit","sen",12,"CSE"));
        hm2.put("rohan05",new Student("rohan05","rohan","thakur",15,"EXNTC"));
        hm2.put("nitesh1",new Student("nitesh1","nitesh","jain",22,"IT"));
        hm2.put("piush3",new Student("piush3","piush","chopra",25,"CHEM"));
        hm2.put("uto7",new Student("uto7","uto","grey",23,"CS"));
    }


    public void addStudent(String id,Student s){
        hm2.put(id,s);
    }


    public HashMap<String, Student> getAllStudent(){
        return hm2;
    }


    public Student getStudentbyId(String id) {
        return hm2.get(id);
    }
    public void updateDepartment(String id,String d){

        Student st=hm2.get(id);
        st.setDepartment(d);
    }

    public void deleteStudent(String id){

        hm2.remove(id);
    }


    public void addEvent(String id, Event e){
        hm1.put(id,e);
    }

    public void updateEvent(String id,Event e){

        hm1.put(id,e);
    }


    public void deleteEvent(Event e){

       hm1.remove(e);
    }


    public HashMap<String, Event> getAll(String d){
        HashMap<String, Event> hm3=new HashMap<>();
        for(Map.Entry<String,Event> e:hm1.entrySet()){
            Event et=e.getValue();
            if(et.getDate().equals(d)){
                hm3.put(e.getKey(),e.getValue());
            }
        }
        return hm3;
    }
}
