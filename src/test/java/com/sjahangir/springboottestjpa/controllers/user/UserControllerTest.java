package com.sjahangir.springboottestjpa.controllers.user;

import com.sjahangir.springboottestjpa.models.user.User;
import com.sjahangir.springboottestjpa.repositories.user.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    private static List<User> allUsers;

    @BeforeAll
    static void setUp() {
        allUsers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            User user = new User(i, "User " + i, "Family " + i);
            allUsers.add(user);
        }
    }

    @Test
    void test_getAllUsers() {
        when(userRepository.findAll()).thenReturn(allUsers);
        List<User> users = userController.getUsers();
        assertEquals(allUsers, users);
    }

    @Test
    void test_getUser() {
        User user = allUsers.get(0);
        when(userRepository.findById(anyInt())).thenReturn(Optional.ofNullable(user));
        User fetchedUser = userController.getUser(2);
        assertEquals(fetchedUser, user);
    }

    @Test
    void test_addUser() {
        User user = new User(0, "Sam", "Khan");
        when(userRepository.save(user)).thenReturn(user);
        ResponseEntity<User> userResponseEntity = userController.addUser(user);
        assertEquals(user, userResponseEntity.getBody());
    }
}
