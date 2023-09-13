package com.example.tastyapp.repositories;

import com.example.tastyapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findByName(String username);


}
