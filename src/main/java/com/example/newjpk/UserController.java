package com.example.newjpk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @PostMapping("/api/createuser")
    public void createNewUser(@Valid @RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/api/changeuser")
    public void changeExistingUser(@Valid @RequestBody User user) {
        userService.modifyUser(user);
    }

    @DeleteMapping("/api/removeuser/{id}")
    public void removeUser(@PathVariable(value = "id") long userId) {
        userService.removeUser(userId);
    }

    @GetMapping("/api/viewsingleuser/{id}")
    public User viewUserById(@PathVariable(value = "id") long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/api/viewalluser")
    public List<User> viewAllUser() {
        return userService.getAllUser();
    }

}