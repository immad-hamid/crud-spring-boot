package com.mysqlconnection.connectmysql.controller;

import com.mysqlconnection.connectmysql.entity.User;
import com.mysqlconnection.connectmysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/users")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public @ResponseBody
    User getUser(@PathVariable Integer id) {
        User n = userRepository.findById(id).get();
        return n;
    }

    @PostMapping(path = "/users")
    public @ResponseBody
    User addNewUser(@RequestBody User dto) {
        User n = new User();
        n.setName(dto.getName());
        n.setEmail(dto.getEmail());
        userRepository.save(n);
        return n;
    }

    @PutMapping(path = "/users/{id}")
    public User updateUser(@RequestBody User dto, @PathVariable Integer id) {
        User n;
        n = userRepository.findById(id).get();
        n.setName(dto.getName());
        n.setEmail(dto.getEmail());
        userRepository.save(n);
        return n;
    }

    @DeleteMapping(path = "/users/{id}")
    public User deleteUser(@PathVariable Integer id) {
        User n;
        n = userRepository.findById(id).get();
        userRepository.delete(n);
        return n;
    }

    // add users using query parameters
    @GetMapping(path = "/add")
    public User addNewUser(@RequestParam String name
            , @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return n;
    }
}
