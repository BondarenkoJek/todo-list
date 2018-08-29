package ua.bondarenkojek.services;


import ua.bondarenkojek.models.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void save(User user);

    void deleteById(Long id);

    void deleteUser(User user);

    User findById(Long id);

    User findByName(String name);
}
