package com.javaguides.sample.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaguides.sample.model.Profile;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    
}