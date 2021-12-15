package com.java.server;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<Integer, User> storage = new HashMap<>();

    public User getUserForId(Integer userId) {
        return storage.get(userId);
    }
}
