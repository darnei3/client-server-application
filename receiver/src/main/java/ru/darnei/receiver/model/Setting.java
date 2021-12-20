package ru.darnei.receiver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Setting {

    private List<String> connection;
    private Map<String, String> address;
    private String password;

    public Map<String, String> getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(Map<String, String> address) {
        this.address = address;
    }

    public List<String> getConnection() {
        return connection;
    }

    public void setConnection(List<String> connection) {
        this.connection = connection;
    }

    public Setting(List<String> connection, Map<String, String> address) {
        this.connection = connection;
        this.address = address;
    }

    public Setting() {
    }

}
