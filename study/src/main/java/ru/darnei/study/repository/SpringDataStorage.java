package ru.darnei.study.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.darnei.study.model.User;

import java.util.List;
import java.util.Optional;

@Repository
@ConditionalOnProperty("DATA_STORAGE.SPRING_DATA_STORAGE")
public class SpringDataStorage implements DataStorage{

    SpringData springData;

    public SpringDataStorage(SpringData springData) {
        this.springData = springData;
    }

    @Override
    public User saveUser(User user) {
        springData.save(user);
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        System.out.println("Исползуется Spring data storage");
        return (List<User>) springData.findAll();
    }

    @Override
    public User findByIdUser(Integer id) {
        Optional<User> user = springData.findById(Long.valueOf(id));
        User returnUser = user.get();
        return returnUser;
    }

    @Override
    public User addUser(User user) {
        springData.save(user);
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        springData.deleteById(Long.valueOf(id));
    }
}
