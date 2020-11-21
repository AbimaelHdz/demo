package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.persistance.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    public void deleteById(Integer id);
    
}
