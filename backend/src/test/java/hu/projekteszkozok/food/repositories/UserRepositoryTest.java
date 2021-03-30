package hu.projekteszkozok.food.repositories;

import hu.projekteszkozok.food.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository users;

    @Test
    void findAll() {
        List<User> all = users.findAll();

        assertNotEquals(null,all);
        assertEquals(4,all.size());
    }

    @Test
    void findUserById() {
        User user = users.findUserById(2);

        assertNotEquals(null,user.getName());
    }
}