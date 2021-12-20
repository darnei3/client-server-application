package ru.darnei.receiver.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.darnei.receiver.model.Setting;

@FeignClient(value = "setting", url = "http://localhost:8080", configuration = Setting.class)
public interface SettingClient {
    @RequestMapping("/setting")
    Setting getSettings();
}