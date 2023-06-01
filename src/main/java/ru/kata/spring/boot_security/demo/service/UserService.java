package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    boolean addUser(User user);
    void updateUser(User user);
    User showUser(int id);
    User findByUsername(String username);
    void removeUser(int id);
}
