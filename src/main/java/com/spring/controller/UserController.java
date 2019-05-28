package com.spring.controller;

import com.spring.model.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User userAdd(@RequestBody User user){
        return userService.userAdd(user);
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @PutMapping("/updateUser/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id){
        return userService.updateUser(user,id);
    }

    @GetMapping("/getuser/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
