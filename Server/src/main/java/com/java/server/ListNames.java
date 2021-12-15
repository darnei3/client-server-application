package com.java.server;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "strings")
public class ListNames {
    private List<String> names = new ArrayList<>();

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> strings) {
        this.names = strings;
    }
}
