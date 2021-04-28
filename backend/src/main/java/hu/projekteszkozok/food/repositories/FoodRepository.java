package hu.projekteszkozok.food.repositories;

import hu.projekteszkozok.food.entities.Food;
import hu.projekteszkozok.food.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Food repository.
 */
@Repository
public interface FoodRepository extends CrudRepository<Food, Integer> {
    List<Food> findAll();

    /**
     * Find food by id.
     *
     * @param id the id of the food
     * @return the food
     */
    Food findFoodById(Integer id);
}
