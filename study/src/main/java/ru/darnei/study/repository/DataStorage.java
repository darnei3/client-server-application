package ru.darnei.study.repository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import ru.darnei.study.exception.ResourceNotFoundException;
import ru.darnei.study.model.User;

import java.util.List;

@Repository
public interface DataStorage {

     ResponseEntity<User> updateUser(Long id, User user) throws ResourceNotFoundException;

     List<User> findAllUsers();

     ResponseEntity<User> findByIdUser(Long id) throws ResourceNotFoundException;

     ResponseEntity<User> newUser(User user);

     void deleteUser(Long id) throws ResourceNotFoundException;
}
