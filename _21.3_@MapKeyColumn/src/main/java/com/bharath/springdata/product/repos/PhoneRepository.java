package com.bharath.springdata.product.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bharath.springdata.product.entities.Employee;
import com.bharath.springdata.product.entities.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
