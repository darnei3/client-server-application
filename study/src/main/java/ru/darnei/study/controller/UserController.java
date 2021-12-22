package ru.darnei.study.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import ru.darnei.study.model.User;
import ru.darnei.study.repository.DataStorage;
import ru.darnei.study.service.UserService;


import java.util.List;


@RestController
@RequestMapping("/user")
@Api("Контрлллер для управления данными User")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ApiOperation(value = "Получение списка всех записей", response = List.class)
    public List<User> getUsers(){
        return userService.getAll();
    }

    @PostMapping()
    @ApiOperation(value = "Создание новой записи или обновление существующей", response = User.class)
    public User createUser(
            @ApiParam("Введите параметры добавляемого user(a)")@RequestBody User user){
        userService.addUser(user);
        return user;
    }


    @GetMapping("/{userId}")
    @ApiOperation(value = "Получение записи", response = User.class)
    public User getUser(
            @ApiParam(value = "Укажите id необходимого вам User", required = true) @PathVariable Integer userId){
        return userService.getUser(userId);
    }


    @DeleteMapping("/{userId}")
    @ApiOperation("Удаление записи")
    public void deleteUser(
            @ApiParam("Введите id user(a) которого вы хотите удалить")@PathVariable Integer userId){
        userService.delete(userId);
    }





}
