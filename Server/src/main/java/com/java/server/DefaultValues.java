package com.java.server;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;



@Configuration
@ConfigurationProperties("df")
public class DefaultValues {
    private Integer port;
    private String url;
    private int randomValue;


    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public int getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(int randomValue) {
        this.randomValue = randomValue;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
