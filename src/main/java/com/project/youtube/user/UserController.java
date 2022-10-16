package com.project.youtube.user;

import com.project.youtube.user.dto.body.CreateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    UserServiceInterface userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
     User createUser(@Valid @RequestBody CreateUserDTO user){
        return userService.createUser(user);
    }

    @GetMapping
    Page<User> getUsers(Pageable pageable){
        return userService.findAll(pageable);
    }

    @GetMapping("findById/{id}")
    User getUserById(@PathVariable("id") UUID id){
        return userService.findById(id).orElseThrow();
    }

    @GetMapping("findByEmail/{email}")
    User getUserByEmail(@PathVariable("email") String email){
        return userService.findByEmail(email).orElseThrow();
    }
}
