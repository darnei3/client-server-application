package ru.darnei.study.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix="storage")
public class Property {
    private Type type;

    private static enum Type{
        SPRING_DATA_JDBC,
        JPA,
        JDBC_TEMPLATE;

    }

    public Property(Type type) {
        this.type = type;
    }

    public Property() {
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
