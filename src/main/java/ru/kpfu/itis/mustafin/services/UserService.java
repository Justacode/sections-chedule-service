package ru.kpfu.itis.mustafin.services;

import ru.kpfu.itis.mustafin.models.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getByLogin(String login);

    User getById(long id);

    void delete(long id);
}
