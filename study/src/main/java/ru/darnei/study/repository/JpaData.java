package ru.darnei.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.darnei.study.model.User;

public interface JpaData extends JpaRepository<User,Long> {

}
