package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("list")
    public ModelAndView listUser(){
        ModelAndView modelAndView = new ModelAndView("user/list", "user", service.findAll());
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView saveUser(){
        ModelAndView modelAndView = new ModelAndView("user/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView saveUser(@ModelAttribute("user") User user){
        service.save(user);
        ModelAndView modelAndView = new ModelAndView("user/create");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("message", "User: " + user.getUsername() + " create successfully!");
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable Integer id, Model model){
        model.addAttribute("user", service.get(id));
        return "user/delete";
    }

    @PostMapping("delete")
    public ModelAndView delete(@ModelAttribute("user") User user){
        service.delete(user.getId());
        ModelAndView modelAndView = new ModelAndView("user/delete");
        modelAndView.addObject("message", "User name: " + user.getUsername() + " deleted successfully !");
        return modelAndView;
    }

    @GetMapping("update/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("user", service.get(id));
        return "user/update";
    }
    @PostMapping("update")
    public ModelAndView update(@ModelAttribute("user") User user){
        service.save(user);
        ModelAndView modelAndView = new ModelAndView("user/update");
        modelAndView.addObject("message", "User id: " + user.getId() + " updated successfully !");
        return modelAndView;
    }
}
