package com.project.system.User.Management.System.with.validation.dao;

import com.project.system.User.Management.System.with.validation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
}
