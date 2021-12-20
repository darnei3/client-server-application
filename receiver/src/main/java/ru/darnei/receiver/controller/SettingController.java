package ru.darnei.receiver.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.darnei.receiver.model.Setting;
import ru.darnei.receiver.service.SettingClient;

@RestController
@Api("Контроллер для вызова запросов сервера")
public class SettingController {

private final SettingClient settingClient;
    public SettingController(SettingClient settingClient) {
        this.settingClient = settingClient;
    }

    @GetMapping
    @RequestMapping(value = "/template", method = RequestMethod.GET)
    @ApiOperation("Получить все настройки от сервера с помощью RestTemplate")
    public Setting getSettingRestTemplate(){
        RestTemplate template = new RestTemplate();
        return template.getForObject("http://localhost:8080/setting", Setting.class);
    }

    @GetMapping
    @RequestMapping( value = "/feign", method = RequestMethod.GET)
    @ApiOperation("Получить все настройки от сервера с помощью Feign")
    public Setting getSettingFeign(){
        return settingClient.getSettings();
    }


}
