package com.javaguides.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaguides.sample.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
