package ru.darnei.study.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import ru.darnei.study.model.User;

import java.util.List;
import java.util.Optional;

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
    public User updateUser(Integer id, User user) {
        if (jpaImplementation.existsById(id.longValue())) {
            User userReturn = new User(id.longValue(), user.getLogin(), user.getEmail(), user.getPassword(), user.getSalary());
            return jpaImplementation.save(userReturn);
        }
        logger.info("Update failed, user with id({}) is not exist", id);
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return jpaImplementation.findAll();
    }

    @Override
    public User findByIdUser(Integer id) {
        Optional<User> user = jpaImplementation.findById(Long.valueOf(id));
        User returnUser = user.get();
        return returnUser;
    }

    @Override
    public User newUser(User user) {
        jpaImplementation.save(user);
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        jpaImplementation.deleteById(Long.valueOf(id));
    }
}
