package ru.darnei.study.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.darnei.study.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringData extends CrudRepository<User,Long> {
}
