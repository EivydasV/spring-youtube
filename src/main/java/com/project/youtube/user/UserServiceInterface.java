package com.project.youtube.user;

import com.project.youtube.user.dto.body.CreateUserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
public interface UserServiceInterface {
    Page<User> findAll(Pageable pageable);
    User createUser(CreateUserDTO user);
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
}
