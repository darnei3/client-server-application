package ru.darnei.study.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import ru.darnei.study.exception.ResourceNotFoundException;
import ru.darnei.study.model.User;

import java.util.List;

@Repository
@ConditionalOnProperty(value = "storage.type", havingValue = "jpa")
public class DataStorageJpaImplementation implements DataStorage{


    Logger logger = LoggerFactory.getLogger(DataStorageJpaImplementation.class);

    {
        logger.info("JPA now using");
    }

    JpaImplementation jpaImplementation;

    public DataStorageJpaImplementation(JpaImplementation jpaImplementation) {
        this.jpaImplementation = jpaImplementation;
    }

    @Override
    public ResponseEntity<User> updateUser(Long id, User userDetails) throws ResourceNotFoundException {
        User user = jpaImplementation.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id : " + id));
        user.setEmail(userDetails.getEmail());
        user.setLogin(userDetails.getLogin());
        user.setPassword(userDetails.getPassword());
        user.setSalary(userDetails.getSalary());
        final User updatedUser = jpaImplementation.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @Override
    public List<User> findAllUsers() {
        return jpaImplementation.findAll();
    }

    @Override
    public ResponseEntity<User> findByIdUser(Long id) throws ResourceNotFoundException {
        User user = jpaImplementation.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id : " + id));
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> newUser(User user) {
        jpaImplementation.save(user);
        return ResponseEntity.ok(user);
    }

    @Override
    public void deleteUser(Long id) throws ResourceNotFoundException{
        jpaImplementation.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id : " + id));
        jpaImplementation.deleteById(id);
    }
}
