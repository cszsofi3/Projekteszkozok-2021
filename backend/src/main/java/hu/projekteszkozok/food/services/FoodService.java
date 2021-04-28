package hu.projekteszkozok.food.services;

import hu.projekteszkozok.food.entities.Food;
import hu.projekteszkozok.food.entities.Ingredient;
import hu.projekteszkozok.food.entities.Type;
import hu.projekteszkozok.food.repositories.FoodRepository;
import hu.projekteszkozok.food.repositories.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Food service.
 */
@RequiredArgsConstructor
@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    /**
     * Add food to the database.
     *
     * @param food the food
     * @return the created food
     */
    public Food createFood(Food food) {
        List<Ingredient> ingredientList = food.getIngredient();

        for(Ingredient currentIngredient : ingredientList) {
            ingredientRepository.save(currentIngredient);
        }
        foodRepository.save(food);
        return food;
    }

    /**
     * Delete food from database.
     *
     * @param id the id of the food
     * @return message on success
     */
    public String deleteFood(Integer id) {
        Food currentFood = foodRepository.findFoodById(id);
        foodRepository.delete(currentFood);
        return "deleted";
    }

    /**
     * List of foods of the same type.
     *
     * @param type the type of the food
     * @return the list of foods
     */
    public List<Food> listFoodByType(Type type) {
        Iterable<Food> allFood = foodRepository.findAll();
        List<Food> currentFoods = new ArrayList<>();
        for(Food food: allFood) {
            switch(type) {
                case PIZZA :
                    if(food.getType().equals(Type.PIZZA)) {
                        currentFoods.add(food);
                    }
                    break;
                case HAMBURGER:
                    if(food.getType().equals(Type.HAMBURGER)) {
                        currentFoods.add(food);
                    }
                    break;
            }
        }
        return currentFoods;
    }
}
