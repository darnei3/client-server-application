package ru.darnei.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.darnei.server.config.Setting;

import java.util.List;

@RestController
@RequestMapping("/setting")
public class SettingController {
    private Setting setting;

    public SettingController(Setting setting) {
        this.setting = setting;
    }

    @GetMapping
    public Setting getSetting(){
        return setting;
    }
}
