package ru.darnei.study.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.darnei.study.model.User;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
@ConditionalOnProperty(value = "storage.type", havingValue = "jdbc_template")
class DataStorageJdbcTemplateImplementation implements DataStorage{


    Logger logger = LoggerFactory.getLogger(DataStorageJdbcTemplateImplementation.class);

    {
        logger.info("JDBC Template now using");
    }

    JdbcTemplate jdbcTemplate;

    public DataStorageJdbcTemplateImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User updateUser(Integer id, User user) {
        String sql = "SELECT COUNT(*) FROM usr WHERE id = ?";
        boolean exists = false;
        int count = jdbcTemplate.queryForObject(sql,new Object[]{id}, Integer.class);
        exists = count > 0;
        if(exists) {
            jdbcTemplate.update("UPDATE USR SET login=?, email=?, password=?, salary=? WHERE id=?",
                    user.getLogin(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getSalary(),
                    id);
            return new User(id.longValue(), user.getLogin(), user.getEmail(), user.getPassword(), user.getSalary());
        }
        else
            return null;
    }



    @Override
    public List<User> findAllUsers() {
        List<User> users = jdbcTemplate.query("SELECT * FROM usr", (result, rowNum) -> new User(
                result.getLong("id"),
                result.getString("login"),
                result.getString("email"),
                result.getString("password"),
                result.getInt("salary")));
        return users;
    }

    @Override
    public User findByIdUser(Integer id) {
        User user = jdbcTemplate.queryForObject("SELECT * FROM usr WHERE ID=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    @Override
    public User newUser(User user) {
        String sql = "INSERT INTO usr (login,email,password,salary) VALUES (?,?,?,? )";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getSalary());
            return ps;
        }, keyHolder);
        return new User(keyHolder.getKey().longValue(), user.getLogin(), user.getEmail(), user.getPassword(), user.getSalary());
    }

    @Override
    public void deleteUser(Integer id) {
        jdbcTemplate.update("DELETE FROM usr WHERE id=?", id);
    }
}
