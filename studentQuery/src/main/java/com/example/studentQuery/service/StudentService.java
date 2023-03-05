package com.example.studentQuery.service;

import com.example.studentQuery.dao.StudentRepository;
import com.example.studentQuery.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void saveStudent(Student student){

        studentRepository.save(student);

    }

    public JSONArray getStudentByName(String first, String last){
        JSONArray response=new JSONArray();
        List<Student> studentList=studentRepository.findStudentByName(first,last);
        for(Student s:studentList){
            JSONObject studentObj=createResponse(s);
            response.put(studentObj);
        }
        return response;
    }

    public JSONArray getStudentByAge(int age){
        JSONArray response=new JSONArray();
        List<Student> studentList=studentRepository.findStudentByAge(age);
        for(Student s:studentList){
            JSONObject studentObj=createResponse(s);
            response.put(studentObj);
        }
        return response;
    }

    public JSONArray getStudentByActive(boolean active){
        JSONArray response=new JSONArray();
        List<Student> studentList=studentRepository.findStudentByActive(active);
        for(Student s:studentList){
            JSONObject studentObj=createResponse(s);
            response.put(studentObj);
        }
        return response;
    }

    public JSONArray getAllStudent(){
        JSONArray response=new JSONArray();
        List<Student> studentList=studentRepository.findAllStudent();
        for(Student s:studentList){
            JSONObject studentObj=createResponse(s);
            response.put(studentObj);
        }
        return response;
    }

    public void deleteStudentByAge(int age){
        studentRepository.deleteById(age);
    }





    private JSONObject createResponse(Student student){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("firstName",student.getFirstName());
        jsonObject.put("lastName",student.getLastName());
        jsonObject.put("age",student.getAge());
        jsonObject.put("active",student.getActive());
        jsonObject.put("admissionDate",student.getAdmissionDate());

        return  jsonObject;
    }

}