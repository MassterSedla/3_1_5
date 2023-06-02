package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public AdminController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping()
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userServiceImpl.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String addNewUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @GetMapping("/user/{id}")
    public String show(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userServiceImpl.showUser(id));
        return "user";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userServiceImpl.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/user/{id}/edit")
    public String edit(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("user", userServiceImpl.showUser(id));
        return "edit";
    }

    @PatchMapping("/user/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id){
        user.setId(id);
        userServiceImpl.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping(value = "/user/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userServiceImpl.removeUser(id);
        return "redirect:/admin";
    }
}

