package hu.projekteszkozok.food.controllers;

import hu.projekteszkozok.food.entities.User;
import hu.projekteszkozok.food.repositories.UserRepository;
import hu.projekteszkozok.food.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> allUser() {return userRepository.findAll();}

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        user.setBasketPrice(0);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    @PostMapping("{id}/add/{userId}")
    public User addFoodToBasket(@PathVariable Integer id, @PathVariable Integer userId) {
        return userService.addFoodToBasket(id, userId);
    }

    @DeleteMapping("/{id}/delete/{userId}")
    public String deleteFoodFromBasket(@PathVariable Integer id, @PathVariable  Integer userId) {
        return userService.deleteFoodFromBasket(id, userId);
    }

//    @PostMapping("/{id}/extra/{ingredientId}")
//    public User addExtraIngredient(Integer id, Integer ingredientId) {
//        return userService.addExtraIngredient(id, ingredientId);
//    }
//    @PostMapping("/{id}/deleteExtra/{ingredientId}")
//    public String deleteExtraIngredient(Integer id, Integer ingredientId) {
//        return userService.deleteExtraIngredient(id, ingredientId);
//    }

}
