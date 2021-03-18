package hu.projekteszkozok.food.repositories;

import hu.projekteszkozok.food.entities.BasketFood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketFoodRepository extends CrudRepository<BasketFood, Integer> {

    BasketFood findBasketFoodById(Integer id);

}
