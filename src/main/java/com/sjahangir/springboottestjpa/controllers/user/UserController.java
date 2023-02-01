package com.sjahangir.springboottestjpa.controllers.user;

import com.sjahangir.springboottestjpa.controllers.user.exceptions.UserNotFoundException;
import com.sjahangir.springboottestjpa.models.user.User;
import com.sjahangir.springboottestjpa.repositories.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") final int id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            String errorMessage = String.format("User not found for id %d", id);
            throw new UserNotFoundException(errorMessage);
        });

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody final User user) {
        User createdUser = userRepository.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") final int id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") final int id, @RequestBody final User user) {
        User userById = userRepository.findById(id).orElseThrow(() -> {
            String errorMessage = String.format("User not found for id %d", id);
            throw new UserNotFoundException(errorMessage);
        });

        userById.setFirstName(user.getFirstName());
        userById.setLastName(user.getLastName());

        User updatedUser = userRepository.save(userById);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
