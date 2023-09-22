package by.flameksandr.mokito.dao;

import by.flameksandr.mokito.model.User;

public interface UserDao {
    User getUserByUsername(String username) throws Exception;
}
