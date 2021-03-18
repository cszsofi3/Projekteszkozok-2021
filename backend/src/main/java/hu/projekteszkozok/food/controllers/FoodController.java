package hu.projekteszkozok.food.controllers;

import hu.projekteszkozok.food.entities.Food;
import hu.projekteszkozok.food.entities.Type;
import hu.projekteszkozok.food.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import hu.projekteszkozok.food.services.FoodService;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/all")
    public Iterable<Food> listAllFood() {
        return foodRepository.findAll();
    }

    @GetMapping("/{id}")
    public Food foodById(@PathVariable Integer id) {
        return foodRepository.findFoodById(id);
    }

    @GetMapping("/pizza")
    public List<Food> listPizzas() {
        return foodService.listFoodByType(Type.PIZZA);
    }

    @GetMapping("/hamburger")
    public List<Food> listHamburgers() {
        return foodService.listFoodByType(Type.HAMBURGER);
    }

    @PostMapping("/create")
    public Food createFood(@RequestBody Food food) {
        return foodService.createFood(food);
    }

    @DeleteMapping("/{id}/delete")
    public String deleteFood(@PathVariable Integer id) {
        return foodService.deleteFood(id);
    }
}
