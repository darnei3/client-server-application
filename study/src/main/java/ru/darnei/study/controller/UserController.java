package ru.darnei.study.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import ru.darnei.study.model.User;
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
        User user = new User(login,email,password,salary);
        return userService.newUser(user);
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "Получение записи", response = User.class)
    public User getUser(
            @ApiParam(value = "Укажите id необходимого вам User", required = true) @PathVariable Integer userId){
        return userService.getUser(userId);
    }

    @PutMapping()
    public User updateUser(
            @RequestParam(value = "id") Integer id,
            @RequestParam(value = "login") String login,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "salary") Integer salary){
        User user = new User(login,email,password, salary);
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{userId}")
    @ApiOperation("Удаление записи")
    public void deleteUser(
            @ApiParam("Введите id user(a) которого вы хотите удалить")@PathVariable Integer userId){
        userService.delete(userId);
    }






}
