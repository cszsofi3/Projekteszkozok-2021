package hu.projekteszkozok.food.controllers;

import hu.projekteszkozok.food.entities.Food;
import hu.projekteszkozok.food.entities.Type;
import hu.projekteszkozok.food.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import hu.projekteszkozok.food.services.FoodService;

import java.util.List;

/**
 * The type Food controller.
 */
@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private FoodRepository foodRepository;

    /**
     * All food list.
     *
     * @return the list of every food in the database
     */
    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Food> listAllFood() {
        return foodRepository.findAll();
    }

    /**
     * Find food by id.
     *
     * @param id the id of the food
     * @return the food
     */
    @GetMapping("/{id}")
    public Food foodById(@PathVariable Integer id) {
        return foodRepository.findFoodById(id);
    }

    /**
     * List of pizzas.
     *
     * @return the list
     */
    @CrossOrigin
    @GetMapping("/pizza")
    public List<Food> listPizzas() {
        return foodService.listFoodByType(Type.PIZZA);
    }

    /**
     * List of hamburgers.
     *
     * @return the list
     */
    @GetMapping("/hamburger")
    public List<Food> listHamburgers() {
        return foodService.listFoodByType(Type.HAMBURGER);
    }

    /**
     * Create new food.
     *
     * @param food the food
     * @return the food
     */
    @PostMapping("/create")
    public Food createFood(@RequestBody Food food) {
        return foodService.createFood(food);
    }

    /**
     * Delete food from database.
     *
     * @param id the id of the food
     * @return message on success
     */
    @DeleteMapping("/{id}/delete")
    public String deleteFood(@PathVariable Integer id) {
        return foodService.deleteFood(id);
    }
}
