package ru.kpfu.itis.mustafin.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.mustafin.models.User;
import ru.kpfu.itis.mustafin.repositories.UserRepository;
import ru.kpfu.itis.mustafin.services.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    public UserServiceImpl(UserRepository userRepository){
        this.repository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public User getById(long id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
