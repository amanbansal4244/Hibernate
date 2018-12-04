package com.bharath.springdata.product.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bharath.springdata.product.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
