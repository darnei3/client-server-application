package ru.darnei.server.config;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ru.darnei.server.model.TestClass;

@Configuration
@EnableConfigurationProperties(TestClass.class)
public class PropertyConfig {
}
