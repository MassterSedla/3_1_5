package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;
import ru.kata.spring.boot_security.demo.model.User;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestAPIController {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public RestAPIController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/page")
    public ResponseEntity<List<User>> showAllUsers() {
        return new ResponseEntity<>(userServiceImpl.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/page/user")
    public ResponseEntity<User> authUser(Principal principal) {
        return new ResponseEntity<>(userServiceImpl.findByUsername(principal.getName()), HttpStatus.OK);
    }

    @GetMapping("/page/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        return new ResponseEntity<>(userServiceImpl.showUser(id), HttpStatus.OK);
    }

    @PostMapping("/page")
    public ResponseEntity<HttpStatus> addNewUser(@RequestBody User user) {
        userServiceImpl.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/page")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User user) {
        userServiceImpl.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/page/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id) {
        userServiceImpl.removeUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}