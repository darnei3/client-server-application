package ru.darnei.study.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.darnei.study.model.User;

import java.util.List;

@Repository
public interface DataStorage {

     User saveUser(User user);

     List<User> findAllUsers();

     User findByIdUser(Integer id);

     User addUser(User user);

     void deleteUser(Integer id);
}
