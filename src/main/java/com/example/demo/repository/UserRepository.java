package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("select a from User a where a.username = :username and a.pass = :pass")
    public User login(@Param("username") String username, @Param("pass") String pass);
}
