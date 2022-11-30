package com.airline.userdemo.controller;

import com.airline.userdemo.model.User;
import com.airline.userdemo.service.UserServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/api")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserServiceAPI userServiceAPI;

    @GetMapping(value="/all")
    public List<User> getAll() {
        return userServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public User find(@PathVariable String id) {
        return userServiceAPI.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        User obj = userServiceAPI.save(user);
        return new ResponseEntity<User>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable String id) {
        User user = userServiceAPI.get(id);
        if(user != null) {
            userServiceAPI.delete(id);
        } else {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
