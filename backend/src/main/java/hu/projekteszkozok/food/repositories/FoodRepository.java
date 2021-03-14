package hu.projekteszkozok.food.repositories;

import hu.projekteszkozok.food.entities.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, Integer> {

    Food findFoodById(Integer id);
}
