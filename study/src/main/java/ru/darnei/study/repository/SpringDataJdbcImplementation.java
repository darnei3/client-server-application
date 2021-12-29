package ru.darnei.study.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.darnei.study.model.User;

@Repository
public interface SpringDataJdbcImplementation extends CrudRepository<User,Long> {


}
