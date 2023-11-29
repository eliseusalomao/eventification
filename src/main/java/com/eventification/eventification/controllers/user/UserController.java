package com.eventification.eventification.controllers.user;

import com.eventification.eventification.models.user.User;
import com.eventification.eventification.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody User user) {
        try {
            User createdUser = service.create(user.getName(), user.getEmail(), user.getPassword(), user.getRole().toString());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }
}
