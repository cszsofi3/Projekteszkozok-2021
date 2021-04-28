package hu.projekteszkozok.food.services;

import hu.projekteszkozok.food.entities.Ingredient;
import hu.projekteszkozok.food.repositories.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Ingredient service.
 */
@RequiredArgsConstructor
@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    /**
     * List of all ingredients.
     *
     * @return the list
     */
    public List<String> listAllIngredients() {
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        List<String> allIngredients = new ArrayList<>();

        for(Ingredient currentIngredient : ingredientList) {
            if(!allIngredients.contains(currentIngredient.getName())) {
                allIngredients.add(currentIngredient.getName());
            }
        }
        return allIngredients;
    }
}
