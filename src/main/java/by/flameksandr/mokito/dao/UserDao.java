package by.flameksandr.mokito.dao;

import by.flameksandr.mokito.model.User;

import java.util.List;

public interface UserDao {
    User getUserByUsername(String username) throws Exception;

    List<User> findAllUsers();
}
