package ru.darnei.study.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.darnei.study.model.User;

import java.util.List;

@Repository
@ConditionalOnProperty("DATA_STORAGE.TEMPLATE_STORAGE")
class TemplateStorage implements DataStorage{

    JdbcTemplate jdbcTemplate;
    public TemplateStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User saveUser(User user) {
        jdbcTemplate.update("UPDATE USER SET LOGIN=?, EMAIL=?,PASSWORD=? WHERE ID=?",
                user.getLogin(),
                user.getEmail(),
                user.getPassword(),
                user.getId());
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = jdbcTemplate.query("SELECT * FROM USER", (result, rowNum) -> new User(result.getLong("ID"),
                result.getString("LOGIN"), result.getString("EMAIL"), result.getString("PASSWORD")));
        System.out.println("Исползуется JDBC Template");
        return users;
    }

    @Override
    public User findByIdUser(Integer id) {
        User user = jdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    @Override
    public User addUser(User user) {
        jdbcTemplate.update("INSERT INTO USER VALUES ( ?,?,?,? )",user.getId(),user.getLogin(), user.getEmail(), user.getEmail());
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        jdbcTemplate.update("DELETE FROM USER WHERE ID=?", id);
    }
}
