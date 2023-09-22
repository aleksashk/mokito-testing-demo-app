package by.flameksandr.mokito.dao;

import by.flameksandr.mokito.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private List<User> users = new ArrayList<>();

    public UserDaoImpl() {
        this.users = Arrays.asList(
                new User("aleks@gmail.com", "GUEST"),
                new User("john@gmail.com", "USER"),
                new User("helga@gmail.com", "ADMIN"));
    }

    @Override
    public User getUserByUsername(String username) throws Exception {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny()
                .orElse(null);
    }
}
