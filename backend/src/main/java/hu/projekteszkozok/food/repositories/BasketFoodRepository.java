package hu.projekteszkozok.food.repositories;

import hu.projekteszkozok.food.entities.BasketFood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Basket food repository.
 */
@Repository
public interface BasketFoodRepository extends CrudRepository<BasketFood, Integer> {

    /**
     * Find every food in a basket by id.
     *
     * @param id the id of the basket
     * @return the foods in the basket
     */
    BasketFood findBasketFoodById(Integer id);

}
