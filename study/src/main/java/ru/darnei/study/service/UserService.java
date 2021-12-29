package ru.darnei.study.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.darnei.study.exception.ResourceNotFoundException;
import ru.darnei.study.model.User;
import ru.darnei.study.repository.DataStorage;

import java.util.List;


@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class.getName());

    DataStorage dataStorage;

    public UserService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public ResponseEntity<User> updateUser(Long id, User user) throws ResourceNotFoundException {
        return dataStorage.updateUser(id, user);
    }



    public ResponseEntity<User> newUser(User user){
        logger.info("User has been added");
        logger.debug("addUser method info {}",user.getId());
        logger.trace("Saving users with {} parameters has been done", user.toString());
        return dataStorage.newUser(user);
    }

    public List<User> getAll(){
        logger.info("Search all users has been done");
        return dataStorage.findAllUsers();
    }

    public ResponseEntity<User> getUser(Long id) throws ResourceNotFoundException{
        return dataStorage.findByIdUser(id);
    }

    public void delete(Long id) throws ResourceNotFoundException{
       dataStorage.deleteUser(id);
    }
}