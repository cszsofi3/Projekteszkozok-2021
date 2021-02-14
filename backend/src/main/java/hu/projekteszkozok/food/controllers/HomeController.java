package hu.projekteszkozok.food.controllers;

import hu.projekteszkozok.food.repositories.BasketRepository;
import hu.projekteszkozok.food.repositories.FoodRepository;
import hu.projekteszkozok.food.repositories.IngredientRepository;
import hu.projekteszkozok.food.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
