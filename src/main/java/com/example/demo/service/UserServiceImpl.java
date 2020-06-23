package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository rep;

    @Override
    public List<User> findAll() {
        return (List<User>) rep.findAll();
    }

    @Override
    public void save(User user){
        rep.save(user);
    }

    @Override
    public void delete(Integer id){
        rep.deleteById(id);
    }

    @Override
    public User get(Integer id){
        return rep.findById(id).get();
    }

    @Override
    public User login(String username, String pass) {
        return rep.login(username, pass);
    }
}
