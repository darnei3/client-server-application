package ru.darnei.study.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import ru.darnei.study.model.User;

import java.util.List;

public interface JpaData extends CrudRepository<User,Long> {

}
