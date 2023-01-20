package com.alvan.springauth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alvan.springauth.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);

    @Query(
        value = "SELECT * from user_entity where email =?1",
        nativeQuery = true
    )
    User findByUsername(String email);
}
