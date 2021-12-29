package ru.darnei.study.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import javax.persistence.*;


@Entity
@Table(name = "usr")
@ApiModel(value = "Модель user", description = "Модель user. Используется для хранения данных user")
public class User {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "ID user(a)")
    private Long id;


    @Column(name = "login")
    @ApiModelProperty(notes = "Логин user(a)")
    private String login;

    @Column(name = "email")
    @ApiModelProperty(notes = "Емейл user(a)")
    private String email;

    @Column(name = "password")
    @ApiModelProperty(notes = "Пароль user(a)")
    private String password;


    @Column(name = "salary")
    @ApiModelProperty(notes = "Заработная плата user(a)")
    private Integer salary;


    public User(String login, String email, String password, Integer salary) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.salary = salary;
    }

    public User(Long id, String login, String email, String password, Integer salary) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.salary = salary;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                '}';
    }
}
