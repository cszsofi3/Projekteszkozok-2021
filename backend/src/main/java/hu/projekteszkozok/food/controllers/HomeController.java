package hu.projekteszkozok.food.controllers;

import hu.projekteszkozok.food.entities.Food;
import hu.projekteszkozok.food.entities.Ingredient;
import hu.projekteszkozok.food.entities.User;
import hu.projekteszkozok.food.repositories.BasketRepository;
import hu.projekteszkozok.food.repositories.FoodRepository;
import hu.projekteszkozok.food.repositories.IngredientRepository;
import hu.projekteszkozok.food.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private BasketRepository basketRepository;

    @GetMapping("users")
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("foods")
    public Iterable<Food> listAllFood() {
        return foodRepository.findAll();
    }

    @GetMapping("food/{id}")
    public Food foodById(@PathVariable Integer id) {

        Food currentFood = foodRepository.findFoodById(id);

        return currentFood;
    }

    @PostMapping("createfood")
    public ResponseEntity<Food> createFood(@RequestBody Food food) {

        foodRepository.save(food);
        List<Ingredient> ingredientList = food.getIngredientList();

        for(Ingredient currentIngredient : ingredientList) {
            currentIngredient.setFood(food);
            ingredientRepository.save(currentIngredient);
        }
        return ResponseEntity.ok(food);
    }

}
