package com.example.medicom.Controllers;

import com.example.medicom.Models.User;
import com.example.medicom.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicomController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String main(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "MainTemplate";
    }
    @PostMapping("/")
    public String mainpost(Model model) {

        return "MainTemplate";
    }

}