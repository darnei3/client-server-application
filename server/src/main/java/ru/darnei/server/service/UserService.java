package ru.darnei.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.darnei.server.model.User;
import ru.darnei.server.repository.UserRepository;

import java.util.HashMap;


/**
 * Класс для обработки отправки и получения данных
 * @autor Evgeny
 * @version 1.0
 */
@Service
public class UserService {

    /** Поле репозитория */
    private final UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    /**
     * Функция возвращения объекта {@link User#User}
     * @param userId id нужного юзера
     * @return возвращает пользователя по указанному id
     */
    public User getUser(Integer userId){
        User user = repository.getUserForId(userId);
        if(user == null){
            throw new IllegalArgumentException();
        }
        return user;
    }

    /**
     * Функция обновления полей объекта {@link User#User}
     * @param id id пользователя
     * @param user объект с обновленными данными
     */
    public void update(Integer id, User user){
        repository.getUserForId(id).setLogin(user.getLogin());
        repository.getUserForId(id).setEmail(user.getEmail());
        repository.getUserForId(id).setPassword(user.getPassword());
    }

    /**
     * Функция добавления в репозиторий объекта {@link User#User}
     * @param user объект добавления в репозиторий
     */
    public void save(User user){
        repository.setUserCount(repository.getUserCount()+1);
        repository.getStorage().put(repository.getUserCount(), user);
    }

    /**
     * Функция удаления из репозитория объекта {@link User#User}
     * @param id id удаляемого юзера
     */
    public void delete(Integer id){
        repository.getStorage().remove(id);
    }

    /**
     * Функция получения всех объектов {@link User#User} из репозитория
     * @return возвращает HashMap(Integer, User)
     */
    public HashMap<Integer, User> getAll(){
        return (HashMap<Integer, User>) repository.getStorage();
    }

}
