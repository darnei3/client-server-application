package ru.darnei.study.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.darnei.study.config.Setting;

@RestController
@RequestMapping("/setting")
@Api("Контроллер для получения настроек из окружения")
public class SettingController {
    private Setting setting;

    public SettingController(Setting setting) {
        this.setting = setting;
    }

    @GetMapping
    @ApiOperation("Получение всех настроек")
    public Setting getSettings(){
        return setting;
    }
}
