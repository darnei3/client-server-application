package ru.darnei.study.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "USER")
@ApiModel(value = "Модель user", description = "Модель user. Используется для хранения данных user")
public class User {

    @javax.persistence.Id
    @Id
    @ApiModelProperty(notes = "ID user(a)")
    private Long id;


    @Column(name = "LOGIN")
    @ApiModelProperty(notes = "Логин user(a)")
    private String login;

    @Column(name = "EMAIL")
    @ApiModelProperty(notes = "Емейл user(a)")
    private String email;

    @Column(name = "PASSWORD")
    @ApiModelProperty(notes = "Пароль user(a)")
    private String password;

    public User(Long id, String login, String email, String password) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

}
