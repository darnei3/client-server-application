package ru.darnei.receiver.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.darnei.receiver.model.User;

import java.util.List;

@FeignClient(value = "users", url = "http://localhost:8080", configuration = User.class)
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "/user")
    List<User> getUsers();

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    User getUser(@PathVariable Integer id);

    @RequestMapping(method = RequestMethod.PUT, value = "/user")
    User updateUser(@RequestParam(value = "id") Integer id,
                    @RequestParam(value = "login") String login,
                    @RequestParam(value = "email") String email,
                    @RequestParam(value = "password") String password,
                    @RequestParam(value = "salary") Integer salary);

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    User newUser(@RequestParam(value = "login") String login,
                 @RequestParam(value = "email")String email,
                 @RequestParam(value = "password")String password,
                 @RequestParam(value = "salary")Integer salary);

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
    void deleteUser(@PathVariable String id);


}