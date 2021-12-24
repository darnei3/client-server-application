package ru.darnei.study.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
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

    public User updateUser(Integer id, User user){
        return dataStorage.updateUser(id, user);
    }

    public User newUser(User user){
        logger.info("User has been added");
        logger.debug("addUser method info {}",user.getId());
        logger.trace("Saving users with {} parameters has been done", user.toString());
        return dataStorage.newUser(user);
    }

    public List<User> getAll(){
        logger.info("Search all users has been done");
        return dataStorage.findAllUsers();
    }

    public User getUser(Integer id){
        try {
            logger.info("Getting a user by id: {} was successful", id);
            return dataStorage.findByIdUser(id);
        } catch (Exception ex) {
            logger.error("Searching for a user by ID gave an error. Check if the ID is correct!", ex);
        }
        return null;
    }

    public void delete(Integer id){
        try {
        logger.info("Deleting a user by id: {} was successful", id);
        dataStorage.deleteUser(id);
        } catch (Exception ex) {
            logger.error("Deleting a user by ID gave an error. Check if the ID is correct!", ex);
        }
    }
}