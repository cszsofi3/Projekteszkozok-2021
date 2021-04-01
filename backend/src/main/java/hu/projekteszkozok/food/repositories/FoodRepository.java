package hu.projekteszkozok.food.repositories;

import hu.projekteszkozok.food.entities.Food;
import hu.projekteszkozok.food.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends CrudRepository<Food, Integer> {
    List<Food> findAll();

    Food findFoodById(Integer id);
}
