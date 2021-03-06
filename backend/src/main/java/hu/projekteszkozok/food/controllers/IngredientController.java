package hu.projekteszkozok.food.controllers;

import hu.projekteszkozok.food.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Ingredient controller.
 */
@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    /**
     * List of all ingredients.
     *
     * @return the list
     */
    @GetMapping("/all")
    public List<String> listAllIngredients() {
        return ingredientService.listAllIngredients();
    }
}
