package com.project.ecommerce.Ecommerce.dao;

import com.project.ecommerce.Ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
