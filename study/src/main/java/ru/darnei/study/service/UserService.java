package ru.darnei.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.darnei.study.model.User;
import ru.darnei.study.repository.DataStorage;

import java.util.List;


/**
 * Класс для обработки отправки и получения данных
 * @version 1.0
 */
@Service
public class UserService {

    DataStorage dataStorage;

    public UserService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public User addUser(User user){
        return dataStorage.saveUser(user);
    }

    public List<User> getAll(){
        return dataStorage.findAllUsers();
    }

    public User getUser(Integer id){
        return dataStorage.findByIdUser(id);
    }

    public void delete(Integer id){
        dataStorage.deleteUser(id);
    }
}