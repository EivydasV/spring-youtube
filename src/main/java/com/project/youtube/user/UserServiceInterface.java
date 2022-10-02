package com.project.youtube.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
public interface UserServiceInterface {
    Page<User> findAll(Pageable pageable);
    User createUser(User user);
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
}
