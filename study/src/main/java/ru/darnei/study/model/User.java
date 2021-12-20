package ru.darnei.study.model;


import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;


/**
 * Класс юзера со свойствами <b>login</b>, <b>email</b> и <b>password</b>.

 * @version 1.0
 */

@ApiModel(value = "Модель user", description = "Модель user. Используется для хранения данных user")
public class User {

    /** Поле логина */
    @ApiModelProperty(notes = "Логин user(a)")
    private String login;

    /** Поле емейл */
    @ApiModelProperty(notes = "Емейл user(a)")
    private String email;

    /** Поле пароля */
    @ApiModelProperty(notes = "Пароль user(a)")
    private String password;

    /**
     * Конструктор - создание объекта класса
     * @param email емейл
     * @param login логин
     * @param password пароль
     * @see User#User(String, String, String)
     */
    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    /**
     * Функция возвращения поля {@link User#login}
     * @return возвращает поле логин
     */
    public String getLogin() {
        return login;
    }

    /**
     * Процедура определения логина {@link User#login}
     * @param login логин
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Функция возвращения поля {@link User#email}
     * @return возвращает поле емейл
     */
    public String getEmail() {
        return email;
    }

    /**
     * Процедура определения емейл {@link User#email}
     * @param email логин
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Функция возвращения поля {@link User#password}
     * @return возвращает поле пароль
     */
    public String getPassword() {
        return password;
    }

    /**
     * Процедура определения пароля {@link User#password}
     * @param password логин
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login) && email.equals(user.email) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email, password);
    }

    @Override
    @JsonValue
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}