package ru.darnei.server.service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Service;
import ru.darnei.server.model.User;
import ru.darnei.server.repository.UserRepository;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

@Service
public class UserSerializer {

//    private UserRepository userRepository;
//
//    public UserSerializer(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    private HashMap<Integer, User> serializeMap = (HashMap<Integer, User>) userRepository.getStorage();
//

}
