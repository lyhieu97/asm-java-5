package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public void save(User user);
    public void delete(Integer id);
    public User get(Integer id);
    public User login(String username, String pass);
}
