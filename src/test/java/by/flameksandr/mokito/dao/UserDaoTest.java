package by.flameksandr.mokito.dao;

import by.flameksandr.mokito.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private UserDao dao;

    @BeforeEach
    public void setUp() throws Exception {
        this.dao = new UserDaoImpl();
    }

    @Test
    void getUserByUsername_Should_Return_True() throws Exception {
        User aleks = dao.getUserByUsername("aleks@gmail.com");
        assertNotNull(aleks);
        assertEquals(aleks.getUsername(), "aleks@gmail.com");

    }

    @Test
    void getUserByUsername_Null_User() throws Exception {
        User gregor = dao.getUserByUsername("gregor@gmail.com");
        assertNull(gregor);
    }

    @Test
    void findAllUsers_Contain() throws Exception {
        List<User> allUsers = dao.findAllUsers();
        assertEquals(allUsers.get(0), new User("aleks@gmail.com", "GUEST"));
        assertTrue(allUsers.contains(new User("aleks@gmail.com", "GUEST")));

    }
}