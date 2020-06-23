package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("login/view");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user, HttpSession session, ModelMap modelMap){
        if(userService.login(user.getUsername(), user.getPass()) != null){
            session.setAttribute("username", user.getUsername());
            session.setAttribute("pass", user.getPass());
            return "redirect:/";
        }else{
            modelMap.put("message", "User's Invalid");
            return "login/view";
        }
    }
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.removeAttribute("username");
        session.removeAttribute("cart");
        return "redirect:/login";
    }
}
