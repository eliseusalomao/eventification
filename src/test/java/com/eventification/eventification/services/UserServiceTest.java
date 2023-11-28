package com.eventification.eventification.services;

import com.eventification.eventification.exceptions.MinimumPasswordLengthRequired;
import com.eventification.eventification.exceptions.UserAlreadyExists;
import com.eventification.eventification.models.user.User;
import com.eventification.eventification.models.user.UserRole;
import com.eventification.eventification.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Test
    void createSuccess() throws UserAlreadyExists, MinimumPasswordLengthRequired {
        User user = new User(1, "Eliseu", "eliseusalomao.dev@gmail.com", "1234567", UserRole.MC);
        User userFromService = service.create(user.getName(), user.getEmail(), user.getPassword(), user.getRole().toString());

        assertEquals(userFromService.getName(), "Eliseu");
    }

    @Test
    void createFailedBecauseUserAlreadyExists() throws UserAlreadyExists, MinimumPasswordLengthRequired {
        User user = new User(1, "Eliseu", "eliseusalomao.dev@gmail.com", "1234567", UserRole.MC);

        repository.save(user);

        Assertions.assertThrows(UserAlreadyExists.class,
                () ->  service.create("Other-user", "eliseusalomao.dev@gmail.com", "other-password", "other-role"));
    }
}