package com.project.ecommerce.Ecommerce.dao;

import com.project.ecommerce.Ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
