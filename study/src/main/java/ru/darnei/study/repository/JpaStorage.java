package ru.darnei.study.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import ru.darnei.study.model.User;

import java.util.List;
import java.util.Optional;

@Repository
@ConditionalOnProperty("DATA_STORAGE.JPA_STORAGE")
public class JpaStorage implements DataStorage{
    JpaData jpaData;

    public JpaStorage(JpaData jpaData) {
        this.jpaData = jpaData;
    }

    @Override
    public User saveUser(User user) {
        jpaData.save(user);
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        System.out.println("Исползуется Jpa storage");
        return (List<User>) jpaData.findAll();
    }

    @Override
    public User findByIdUser(Integer id) {
        Optional<User> user = jpaData.findById(Long.valueOf(id));
        User returnUser = user.get();
        return returnUser;
    }

    @Override
    public User addUser(User user) {
        jpaData.save(user);
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        jpaData.deleteById(Long.valueOf(id));
    }
}
