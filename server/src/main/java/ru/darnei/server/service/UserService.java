package ru.darnei.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.darnei.server.model.User;
import ru.darnei.server.repository.UserRepository;

import java.util.HashMap;

@Service
public class UserService {


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

    public void update(Integer id, User user){
        repository.getUserForId(id).setLogin(user.getLogin());
        repository.getUserForId(id).setEmail(user.getEmail());
        repository.getUserForId(id).setPassword(user.getPassword());
    }

    public void save(User user){
        repository.setUserCount(repository.getUserCount()+1);
        repository.getStorage().put(repository.getUserCount(), user);
    }

    public void delete(Integer id){
        repository.getStorage().remove(id);
    }

//    @Value("${file.store.appId}")
//    Integer integer;

    public HashMap<Integer, User> getAll(){
        return (HashMap<Integer, User>) repository.getStorage();
    }

}
