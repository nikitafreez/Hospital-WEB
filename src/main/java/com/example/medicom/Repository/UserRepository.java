package com.example.medicom.Repository;

import com.example.medicom.Models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Page findAll(Pageable pageable);
    
    User findByUsername(String username);
}
