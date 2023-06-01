package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UsersController {
    private final UserService userServiceImpl;

    @Autowired
    public UsersController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
    @GetMapping()
    public String user(Principal principal, ModelMap model) {
        model.addAttribute("user", userServiceImpl.findByUsername(principal.getName()));
        return "user";
    }
}
