package com.leodias.api_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leodias.api_rest.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
