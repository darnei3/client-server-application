package ru.darnei.study.service;

import org.springframework.stereotype.Service;
import ru.darnei.study.model.User;
import ru.darnei.study.repository.UserRepository;

import java.util.ArrayList;


/**
 * Класс для обработки отправки и получения данных
 * @version 1.0
 */
@Service
public class UserService {

    /**
     * Поле репозитория */
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
        User user = repository.getUser(userId);
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
    public void updateUser(Integer id, User user){
        repository.getUser(id).setLogin(user.getLogin());
        repository.getUser(id).setEmail(user.getEmail());
        repository.getUser(id).setPassword(user.getPassword());

    }

    /**
     * Функция добавления в репозиторий объекта {@link User#User}
     * @param user объект добавления в репозиторий
     */
    public void saveUser(User user){
        repository.setUserCount(repository.getUserCount()+1);
        repository.getStorage().put(repository.getUserCount(), user);
    }

    /**
     * Функция удаления из репозитория объекта {@link User#User}
     * @param id id удаляемого юзера
     */
    public void deleteUser(Integer id){
        repository.getStorage().remove(id);
    }

    /**
     * Функция получения всех объектов {@link User#User} из репозитория
     * @return возвращает HashMap(Integer, User)
     */
    public ArrayList<User> getUsers(){
        return new ArrayList<>(repository.getStorage().values());
    }

}
