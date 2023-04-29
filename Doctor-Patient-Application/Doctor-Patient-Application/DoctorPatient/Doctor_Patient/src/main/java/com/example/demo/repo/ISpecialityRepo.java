package com.example.demo.repo;

import com.example.demo.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISpecialityRepo extends JpaRepository<Speciality,Integer> {
    @Query(value = "Select * From speciality Where speciality_type= :speciality", countQuery = "Select count(*) From speciality", nativeQuery = true)
    public List<Speciality> findBySpeciality(String speciality);
}
