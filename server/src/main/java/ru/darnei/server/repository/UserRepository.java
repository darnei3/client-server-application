package ru.darnei.server.repository;
import org.springframework.stereotype.Repository;
import ru.darnei.server.model.User;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<Integer, User> storage = new HashMap<>();
    private Integer USER_COUNT = 1;
    {
        storage.put(USER_COUNT++,new User("Alex", "alex@mail.ru", "12345"));
        storage.put(USER_COUNT++,new User("Evgen", "evgen@gmail.com", "54321"));
        storage.put(USER_COUNT++,new User("Maxim", "maxim@yandex.ru", "11111"));
        storage.put(USER_COUNT++,new User("Sanchez", "sanchez@rambler.com", "22222"));
        storage.put(USER_COUNT++,new User("Artem", "artem@mail.ru", "33333"));
        storage.put(USER_COUNT,new User("Viktor", "viktor@gmail.com", "44444"));
    }

    public UserRepository() {
    }

    public Integer getUserCount() {
        return USER_COUNT;
    }

    public void setUserCount(Integer userCount) {
        USER_COUNT = userCount;
    }

    public Map<Integer, User> getStorage() {
        return storage;
    }

    public User getUserForId(Integer userId) {
        return storage.get(userId);
    }
}
