package ru.darnei.study.repository;

import org.springframework.stereotype.Repository;
import ru.darnei.study.model.User;

import java.util.List;

@Repository
public interface DataStorage {

     User updateUser(Integer id, User user);

     List<User> findAllUsers();

     User findByIdUser(Integer id);

     User newUser(User user);

     void deleteUser(Integer id);
}
