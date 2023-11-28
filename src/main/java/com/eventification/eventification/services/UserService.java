package com.eventification.eventification.services;

import com.eventification.eventification.exceptions.InvalidName;
import com.eventification.eventification.exceptions.MinimumPasswordLengthRequired;
import com.eventification.eventification.exceptions.UserAlreadyExists;
import com.eventification.eventification.models.user.User;
import com.eventification.eventification.models.user.UserRole;
import com.eventification.eventification.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User create(String name, String email, String password, String role)
            throws UserAlreadyExists,
            MinimumPasswordLengthRequired,
            InvalidName
    {
        Optional<User> userAlreadyExists = repository.findUserByEmail(email);

        if (userAlreadyExists.isPresent()) {
            throw new UserAlreadyExists();
        }

        if (name.trim().isBlank()) {
            throw new InvalidName();
        }

        if (password.length() < 6) {
            throw new MinimumPasswordLengthRequired();
        }

        User userToBeCreated = new User();
        userToBeCreated.setName(name);
        userToBeCreated.setEmail(email);
        userToBeCreated.setPassword(password);
        userToBeCreated.setRole(UserRole.valueOf(role));

        repository.save(userToBeCreated);

        return userToBeCreated;
    }
}
