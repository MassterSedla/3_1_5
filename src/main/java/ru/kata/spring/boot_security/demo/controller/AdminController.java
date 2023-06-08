package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.security.Principal;

@Controller
public class AdminController {

    private final UserServiceImpl userServiceImpl;
//    private final RoleServiceImpl roleServiceImpl;

    @Autowired
    public AdminController(UserServiceImpl userServiceImpl/*, RoleServiceImpl roleServiceImpl*/) {
        this.userServiceImpl = userServiceImpl;
//        this.roleServiceImpl = roleServiceImpl;
    }

    @GetMapping("/page")
    public String printUsers(ModelMap model, Principal principal) {
        model.addAttribute("userAuth", userServiceImpl.findByUsername(principal.getName()));
        return "index";
    }
//
//    @GetMapping("/new")
//    public String addNewUser(ModelMap model) {
//        model.addAttribute("user", new User());
//        return "new";
//    }
//
//    @GetMapping("/user/{id}")
//    public String show(@PathVariable("id") int id, ModelMap model) {
//        model.addAttribute("user", userServiceImpl.showUser(id));
//        return "user";
//    }
//
//    @PostMapping()
//    public String saveUser(@ModelAttribute("user") User user) {
//        userServiceImpl.addUser(user);
//        return "redirect:/";
//    }
//
//    @GetMapping("/user/{id}/edit")
//    public String edit(@PathVariable("id") int id, ModelMap model){
//        model.addAttribute("user", userServiceImpl.showUser(id));
//        return "edit";
//    }
//
//    @PatchMapping("/user/{id}")
//    public String update(@ModelAttribute("user") User user){
//        userServiceImpl.updateUser(user);
//        return "redirect:/";
//    }
//
//    @DeleteMapping(value = "/user/{id}")
//    public String removeUser(@PathVariable("id") int id) {
//        userServiceImpl.removeUser(id);
//        return "redirect:/";
//    }
}

