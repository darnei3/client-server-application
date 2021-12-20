package ru.darnei.receiver.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.darnei.receiver.model.Setting;

import java.util.Set;

@RestController
public class SettingController {


    @GetMapping
    @RequestMapping("/template")
    public Setting getSetting(){
        RestTemplate template = new RestTemplate();
        return template.getForObject("http://localhost:8080/setting", Setting.class);
    }


}
