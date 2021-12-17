package ru.darnei.server.controller;

import org.springframework.web.bind.annotation.*;
import ru.darnei.server.model.User;
import ru.darnei.server.service.UserService;

import java.util.HashMap;


@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService service;
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public HashMap<Integer, User> all(){
        return service.getAll();
    }

    @GetMapping("/{userId}")
    public User one(@PathVariable Integer userId){
        return service.getUser(userId);
    }


    @PostMapping
    public User newUser(@RequestBody User user){
        service.save(user);
        return user;
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Integer userId){
        service.delete(userId);
    }

    @PutMapping("/{userId}")
    public User update(@RequestBody User user, @PathVariable Integer userId){
        service.update(userId,user);
        return service.getUser(userId);
    }



}
