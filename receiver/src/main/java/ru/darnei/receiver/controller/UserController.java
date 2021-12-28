package ru.darnei.receiver.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import ru.darnei.receiver.model.User;
import ru.darnei.receiver.service.UserClient;

import java.util.ArrayList;

@RestController
@RequestMapping("/client")
@Api("Контроллер для вызова запросов сервера")
public class UserController {

private final UserClient userClient;
    public UserController(UserClient userClient) {
        this.userClient = userClient;
    }

//    @GetMapping
//    @RequestMapping(value = "/template", method = RequestMethod.GET)
//    @ApiOperation("Получить все настройки от сервера с помощью RestTemplate")
//    public Setting getSettingRestTemplate(){
//        RestTemplate template = new RestTemplate();
//        return template.getForObject("http://localhost:8080/setting", Setting.class);
//    }

    @GetMapping("/")
    @ApiOperation("Получить всех пользователей")
    public ArrayList<User> getUser(){
        return new ArrayList<User>(userClient.getUsers());
    }


    @GetMapping("/{userId}")
    @ApiOperation(value = "Получение записи", response = User.class)
    public User getUser(
            @ApiParam(value = "Укажите id необходимого вам User", required = true) @PathVariable Integer userId){
        return userClient.getUser(userId);
    }

    @PutMapping()
    public User updateUser(
            @RequestParam(value = "id") Integer id,
            @RequestParam(value = "login") String login,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "salary") Integer salary){
        return userClient.updateUser(id, login, email, password, salary);
    }

    @PostMapping()
    @ApiOperation(value = "Создание новой записи", response = User.class)
    public User newUser(
            @ApiParam("Введите логин добавляемого user(a)")
            @RequestParam(value = "login") String login,
            @ApiParam("Введите емейл добавляемого user(a)")
            @RequestParam(value = "email")String email,
            @ApiParam("Введите пароль добавляемого user(a)")
            @RequestParam(value = "password")String password,
            @ApiParam("Введите зарплату добавляемого user(a)")
            @RequestParam(value = "salary")Integer salary){
        return userClient.newUser(login, email, password, salary);
    }

    @DeleteMapping("/{userId}")
    @ApiOperation("Удаление записи")
    public void deleteUser(
            @ApiParam("Введите id user(a) которого вы хотите удалить")@PathVariable Integer userId){
        userClient.deleteUser(String.valueOf(userId));
    }




}
