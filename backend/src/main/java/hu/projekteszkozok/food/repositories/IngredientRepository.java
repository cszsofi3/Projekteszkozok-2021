package hu.projekteszkozok.food.repositories;

import hu.projekteszkozok.food.entities.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository  extends CrudRepository<Ingredient, Integer> {

    List<Ingredient> findAll();
}
