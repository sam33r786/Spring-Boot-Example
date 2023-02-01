package com.sjahangir.springboottestjpa.controllers.user;

import com.sjahangir.springboottestjpa.controllers.user.exceptions.UserNotFoundException;
import com.sjahangir.springboottestjpa.models.user.User;
import com.sjahangir.springboottestjpa.repositories.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable final int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            String errorMessage = String.format("User not found for id %d", id);
            throw new UserNotFoundException(errorMessage);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody final User user) {
        User createdUser = userRepository.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable final int id) {
        userRepository.deleteById(id);
    }

    @PutMapping("users/{id}")
    public User updateUser(@PathVariable final int id, @RequestBody final User user) {
        User userById = userRepository.findById(id).orElse(null);
        if (userById == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        userById.setFirstName(user.getFirstName());
        userById.setLastName(user.getLastName());

        return userRepository.save(userById);
    }
}
