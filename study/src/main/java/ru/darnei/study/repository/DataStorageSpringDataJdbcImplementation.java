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
@ConditionalOnProperty(value = "storage.type", havingValue = "spring_data_jdbc")
public class DataStorageSpringDataJdbcImplementation implements DataStorage{

    SpringDataJdbcImplementation springDataJdbcImplementation;

    Logger logger = LoggerFactory.getLogger(DataStorageSpringDataJdbcImplementation.class);

    {
        logger.info("Spring Data JDBC now using");
    }

    public DataStorageSpringDataJdbcImplementation(SpringDataJdbcImplementation springDataJdbcImplementation) {
        this.springDataJdbcImplementation = springDataJdbcImplementation;
    }

    @Override
    public ResponseEntity<User> updateUser(Long id, User userDetails) throws ResourceNotFoundException {
        User user = springDataJdbcImplementation.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id : " + id));
        user.setEmail(userDetails.getEmail());
        user.setLogin(userDetails.getLogin());
        user.setPassword(userDetails.getPassword());
        user.setSalary(userDetails.getSalary());
        final User updatedUser = springDataJdbcImplementation.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) springDataJdbcImplementation.findAll();
    }

    @Override
    public ResponseEntity<User> findByIdUser(Long id) throws ResourceNotFoundException {
        User user = springDataJdbcImplementation.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id : " + id));
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> newUser(User user) {
        springDataJdbcImplementation.save(user);
        return ResponseEntity.ok(user);
    }

    @Override
    public void deleteUser(Long id) throws ResourceNotFoundException {
        springDataJdbcImplementation.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id : " + id));
        springDataJdbcImplementation.deleteById(id);
    }
}
