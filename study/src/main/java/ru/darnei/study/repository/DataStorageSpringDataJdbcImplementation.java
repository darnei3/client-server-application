package ru.darnei.study.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import ru.darnei.study.model.User;

import java.util.List;
import java.util.Optional;


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
    public User updateUser(Integer id, User user) {
        if (springDataJdbcImplementation.existsById(id.longValue())) {
            User userReturn = new User(id.longValue(), user.getLogin(), user.getEmail(), user.getPassword(), user.getSalary());
            return springDataJdbcImplementation.save(userReturn);
        }
        logger.info("Update failed, user with id({}) is not exist", id);
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) springDataJdbcImplementation.findAll();
    }

    @Override
    public User findByIdUser(Integer id) {
            Optional<User> user = springDataJdbcImplementation.findById(Long.valueOf(id));
            User returnUser = user.get();
            return returnUser;
    }

    @Override
    public User newUser(User user) {
        springDataJdbcImplementation.save(user);
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        springDataJdbcImplementation.deleteById(Long.valueOf(id));
    }
}
