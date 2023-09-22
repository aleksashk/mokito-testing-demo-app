package by.flameksandr.mokito.services;

import by.flameksandr.mokito.dao.UserDao;
import by.flameksandr.mokito.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

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
        //verify

        verify(dao).getUserByUsername("aleks@gmail.com");
    }

    @Test
    void checkUserPresence_Should_Return_Null() throws Exception {
        given(dao.getUserByUsername("john@gmail.com"))
                .willReturn(null);

        boolean userExists = userService.checkUserPresence(new User("john@gmail.com"));
        Assertions.assertFalse(userExists);
    }

    @Test
    void checkUserPresence_Should_Throw_Exception() throws Exception {
        given(dao.getUserByUsername(anyString()))
                .willThrow(Exception.class);

        assertThrows(Exception.class, () -> userService.checkUserPresence(new User("asdf@gmail.com")));
    }

    @Test
    public void testCaptor() throws Exception {
        given(dao.getUserByUsername(anyString()))
                .willReturn(new User("aleks@gmail.com"));
        boolean b = userService.checkUserPresence(new User("aleks@gmail.com"));

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(dao).getUserByUsername(captor.capture());
        String argument = captor.getValue();
        assertEquals(argument, "aleks@gmail.com");

    }


}