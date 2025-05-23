package com.scm.repsitories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    // extra method db releted
    // costom query methods
    // costom finder methods
    
    Optional<User> findByEmail(String email);   
    Optional<User> findByEmailAndPassword(String email,String password);   

}
