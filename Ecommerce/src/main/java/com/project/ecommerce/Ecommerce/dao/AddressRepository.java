package com.project.ecommerce.Ecommerce.dao;

import com.project.ecommerce.Ecommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
