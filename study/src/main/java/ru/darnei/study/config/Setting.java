package ru.darnei.study.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;


import java.util.List;
import java.util.Map;


@ConfigurationProperties(prefix = "settings")
@ApiModel(value = "Модель setting", description = "Модель setting. Используется для хранения данных загруженных из конфигурационного фалйа")
public class Setting {

    @ApiModelProperty("Лист подключений")
    private List<String> connection;

    @ApiModelProperty("Карта адрессов и портов подключения")
    private Map<String, String> address;

    public Map<String, String> getAddress() {
        return address;
    }

    @ApiModelProperty("Пароль подключения")
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
