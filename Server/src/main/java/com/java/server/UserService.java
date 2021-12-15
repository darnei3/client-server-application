package com.java.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public User getUser(Integer userId){
        User user = repository.getUserForId(userId);
        if(user == null){
            throw new IllegalArgumentException();
        }
        return user;
    }
}
