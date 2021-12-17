package ru.darnei.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "settings")
public class Setting {

    private List<String> connection;

    private Map<String, String> address;

    public Map<String, String> getAddress() {
        return address;
    }


    private String password;

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
