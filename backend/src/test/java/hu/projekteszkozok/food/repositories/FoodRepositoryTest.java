package hu.projekteszkozok.food.repositories;

import hu.projekteszkozok.food.entities.Food;
import hu.projekteszkozok.food.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FoodRepositoryTest {

    @Autowired
    FoodRepository foods;

    @Test
    void findAll() {
        List<Food> all = foods.findAll();

        assertNotEquals(null,all);
        assertEquals(3,all.size());
    }

    @Test
    void findFoodById() {
        Food food = foods.findFoodById(2);

        assertEquals("Cheese",food.getName());
    }
}