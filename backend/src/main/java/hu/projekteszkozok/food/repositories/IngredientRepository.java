package hu.projekteszkozok.food.repositories;

import hu.projekteszkozok.food.entities.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Ingredient repository.
 */
public interface IngredientRepository  extends CrudRepository<Ingredient, Integer> {

    List<Ingredient> findAll();

    /**
     * Find ingredient by id.
     *
     * @param id the id of the ingredient
     * @return the ingredient
     */
    Ingredient findIngredientById(Integer id);
}
