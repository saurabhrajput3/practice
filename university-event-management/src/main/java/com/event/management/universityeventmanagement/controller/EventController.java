package com.event.management.universityeventmanagement.controller;

import com.event.management.universityeventmanagement.model.Event;
import com.event.management.universityeventmanagement.model.Student;
import com.event.management.universityeventmanagement.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/management/unv-event/")
public class EventController {
private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/addStudent/id/{id}")
    public void addStudent(@PathVariable String id, @RequestBody Student s){
        eventService.addStudent(id,s);
    }

    @GetMapping("/getAllStudent")
        public HashMap<String, Student> getAllStudent(){
           return eventService.getAllStudent();
    }

    @GetMapping("/getStudentbyId/id/{id}")
    public Student getStudentbyId(@PathVariable String id){
        return eventService.getStudentbyId(id);
    }

    @PutMapping("/updateStudentDepartment/id/{id}")
    public void updateDepartment(@PathVariable String id,@RequestBody String d){

        eventService.updateDepartment(id,d);
    }

    @DeleteMapping("/deleteStudentinfo/id/{id}")
    public void deleteStudent(@PathVariable String id){

        eventService.deleteStudent(id);
    }

    @PostMapping("/addEvent/id/{id}")
    public void addEvent(@PathVariable String id, @RequestBody Event e){
        eventService.addEvent(id,e);
    }
    @PutMapping("/updateEvent/id/{id}")
    public void updateEvent(@PathVariable String id,@RequestBody Event e){

        eventService.updateEvent(id,e);
    }

    @DeleteMapping("/deleteEvent/id/{id}")
    public void deleteEvent(@PathVariable Event e){

        eventService.deleteEvent(e);
    }

    @GetMapping("/getAllEventbyDate/date/{d}")
    public HashMap<String, Event> getAll(@PathVariable String d){
        return eventService.getAll(d);
    }

}
