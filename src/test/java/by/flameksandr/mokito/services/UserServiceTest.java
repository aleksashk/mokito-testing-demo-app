package by.flameksandr.mokito.services;

import by.flameksandr.mokito.dao.UserDao;
import by.flameksandr.mokito.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserDao dao;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        this.userService = new UserService(dao);
    }

    @Test
    void checkUserPresence_Should_Return_True() throws Exception {
        given(dao.getUserByUsername("aleks@gmail.com"))
                .willReturn(new User("aleks@gmail.com"));

        boolean userExists = userService.checkUserPresence(new User("aleks@gmail.com"));
        Assertions.assertTrue(userExists);
    }
}