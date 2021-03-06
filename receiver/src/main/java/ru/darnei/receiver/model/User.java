package ru.darnei.receiver.model;

public class User {
    private Long id;
    private String login;
    private String email;
    private String password;
    private Integer salary;

    public User(Long id, String login, String email, String password, Integer salary) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.salary = salary;
    }

    public User(String login, String email, String password, Integer salary) {
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
