package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
    @Autowired
    private UserService service;


    @GetMapping("register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView("register/index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("register")
    public String saveUser(@ModelAttribute("user") User user, Model model){
        service.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("message", "Register username: " + user.getUsername()+ " and password: " + user.getPass() + " successfully !");
        return "register/index";
    }
}
