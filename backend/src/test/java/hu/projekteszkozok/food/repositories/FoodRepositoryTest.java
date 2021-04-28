package hu.projekteszkozok.food.repositories;

import hu.projekteszkozok.food.entities.Food;
import hu.projekteszkozok.food.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Food repository test.
 */
@DataJpaTest
class FoodRepositoryTest {

    /**
     * The Foods.
     */
    @Autowired
    FoodRepository foods;

    /**
     * Test for finding all foods.
     */
    @Test
    void findAll() {
        List<Food> all = foods.findAll();

        assertNotEquals(null,all);
        assertEquals(3,all.size());
    }

    /**
     * Test for finding a food by id.
     */
    @Test
    void findFoodById() {
        Food food = foods.findFoodById(2);

        assertNotEquals(null,food.getName());
    }
}