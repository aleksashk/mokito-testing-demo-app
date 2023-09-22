package by.flameksandr.mokito.dao;

import by.flameksandr.mokito.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}