package com.java.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

@RestController("/server")

public class ServerController {

    @Autowired
    private final UserService service;

    public ServerController(UserService service) {
        this.service = service;
    }

    @Autowired
    ListNames defaultStrings;

    @Autowired
    DefaultValues defaultValuesProperties;



    @Autowired
    private Environment env;

    @Value("${terminal.name}") //TERMINAL
        private String name;       //mvn spring-boot:run -Dspring-boot.run.arguments=--terminal.name=Test

    @Value("Some test String")
    String testString;



    @GetMapping("/list")
    public ArrayList getList(){
        return (ArrayList) defaultStrings.getNames();
    }

    @GetMapping("/values")
    public String getValues(){
        return
                defaultValuesProperties.getUrl() +
                        " Random value: " + defaultValuesProperties.getRandomValue() +
                        " Testing value: " + testString +
                        " Terminal value: " + name;
    }

    @GetMapping("/envdetails")
    public String envDetails(){
        return env.toString();
    }

    @GetMapping("/getSysVar")
    public String getSysVar(){
        String javaVersion = System.getProperty("java.version");
        String javaHome = System.getProperty("java.home");
        String osName = System.getProperty("os.name");
        String userName = System.getProperty("user.name");
//        Properties systemProp = System.getProperties();
//        Set<String> setOfSysProp = systemProp.stringPropertyNames();
//        for(String prop: setOfSysProp){
//            System.out.println(prop + " - " + systemProp.getProperty(prop));
//        }
        return "JAVA VERSION: " + javaVersion + " JAVA DIRECTION: " + javaHome + " OS NAME: " + osName + " USER NAME: " + userName;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Integer userId){
        return service.getUser(userId);
    }

}
