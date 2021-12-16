package ru.darnei.server.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.darnei.server.model.User;
import ru.darnei.server.service.UserService;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

@RestController
public class UserController {

    private final UserService service;
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/getUser/{userId}")
    public User getUser(@PathVariable Integer userId){
        return service.getUser(userId);
    }

    @GetMapping("/getAll")
    public HashMap<Integer, User> getAll(){
        return service.getAll();
    }

    @PostMapping("/save")
    public HashMap<Integer, User> save(@RequestBody User user){
        service.save(user);
        return service.getAll();
    }

    @DeleteMapping("/delete/{userId}")
    public HashMap<Integer,User> delete(@PathVariable Integer userId){
        service.delete(userId);
        return service.getAll();
    }

    @PostMapping("/update/{userId}")
    public HashMap<Integer,User> update(@PathVariable Integer userId, @RequestBody User user){
        service.update(userId,user);
        return service.getAll();
    }



}
