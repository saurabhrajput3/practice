package com.project.ecommerce.Ecommerce.dao;

import com.project.ecommerce.Ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
