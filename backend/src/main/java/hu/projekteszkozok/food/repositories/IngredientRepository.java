package hu.projekteszkozok.food.repositories;

import hu.projekteszkozok.food.entities.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository  extends CrudRepository<Ingredient, Integer> {
}
