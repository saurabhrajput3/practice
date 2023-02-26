package com.portal.studentinfo.studentinfo.service;

import com.portal.studentinfo.studentinfo.dao.LaptopRepository;
import com.portal.studentinfo.studentinfo.dao.StudentRepository;
import com.portal.studentinfo.studentinfo.model.Laptop;
import com.portal.studentinfo.studentinfo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class LaptopService {
    @Autowired
    private LaptopRepository laptopRepo;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepo;

    public Laptop addLaptop(Laptop laptopDto) {
        Student byStudent = studentService.findByStudent(laptopDto.getStudentID());
        Laptop laptop = new Laptop();
        String ID = UUID.randomUUID().toString();

        laptop.setID(ID);
        laptop.setName(laptopDto.getName());
        laptop.setBrand(laptopDto.getBrand());
//        Laptop.se(byStudent);
        laptop.setPrice(laptopDto.getPrice());
        laptop.setStudent(byStudent);
//        byStudent.setLaptop(Laptop);

        Laptop __Laptop = laptopRepo.save(laptop);
//        Student save = studentRepo.save(byStudent);
//        return save;
        return __Laptop;
    }

    public Laptop findByLaptop(String laptopId)  {
        Optional<Laptop> LaptopOptional = laptopRepo.findById(laptopId);


            return LaptopOptional.get();


    }

    public List<Laptop> findAllLaptop() {
        List<Laptop> LaptopRepoAll = laptopRepo.findAll();
        return LaptopRepoAll;
    }
}
