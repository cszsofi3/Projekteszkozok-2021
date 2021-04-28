package hu.projekteszkozok.food.controllers;

import hu.projekteszkozok.food.entities.User;
import hu.projekteszkozok.food.repositories.UserRepository;
import hu.projekteszkozok.food.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    /**
     * All user list.
     *
     * @return the list of every user in the database
     */
    @GetMapping("/all")
    public List<User> allUser() {return userRepository.findAll();}

    /**
     * Add user to the database.
     *
     * @param user to add
     * @return the new user added to the database
     */
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        user.setBasketPrice(0);
        return userRepository.save(user);
    }

    /**
     * Delete user from database.
     *
     * @param id of the user
     * @return message on success
     */
    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    /**
     * Add food to a user's basket.
     *
     * @param id     the id of the food
     * @param userId the id of the user
     * @return the user
     */
    @PostMapping("{id}/add/{userId}")
    public User addFoodToBasket(@PathVariable Integer id, @PathVariable Integer userId) {
        return userService.addFoodToBasket(id, userId);
    }

    /**
     * Delete food from a user's basket.
     *
     * @param id     the id of the food
     * @param userId the id of the user
     * @return message on success
     */
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
