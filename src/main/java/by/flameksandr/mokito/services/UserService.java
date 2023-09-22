package by.flameksandr.mokito.services;

import by.flameksandr.mokito.dao.UserDao;
import by.flameksandr.mokito.model.User;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkUserPresence(User user) throws Exception {
        User userByUsername = userDao.getUserByUsername(user.getUsername());
        return userByUsername != null;
    }
}
