package hu.projekteszkozok.food.services;

import hu.projekteszkozok.food.entities.BasketFood;
import hu.projekteszkozok.food.entities.Food;
import hu.projekteszkozok.food.entities.User;
import hu.projekteszkozok.food.repositories.BasketFoodRepository;
import hu.projekteszkozok.food.repositories.FoodRepository;
import hu.projekteszkozok.food.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type User service.
 */
@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private BasketFoodRepository basketFoodRepository;
//    @Autowired
//    private IngredientRepository ingredientRepository;

    /**
     * Delete user from database.
     *
     * @param id the id of the user
     * @return message on success
     */
    public String deleteUser(Integer id) {
        User currentUser = userRepository.findUserById(id);
        userRepository.delete(currentUser);

        return currentUser.getName() + " deleted";
    }

    /**
     * Add food to user's basket.
     *
     * @param id     the id of the food
     * @param userId the id of the user
     * @return the user
     */
    public User addFoodToBasket(Integer id, Integer userId) {
        Food currentFood = foodRepository.findFoodById(id);
        User currentUser = userRepository.findUserById(userId);
        Integer currentPrice = currentUser.getBasketPrice();
        List<BasketFood> foods = currentUser.getBasket();

        BasketFood currentBasketFood = BasketFood.builder()
                .owner(currentUser)
                .name(currentFood.getName())
                .price(currentFood.getPrice())
                .build();

        foods.add(currentBasketFood);
        currentUser.setBasket(foods);
        currentPrice += currentBasketFood.getPrice();
        currentUser.setBasketPrice(currentPrice);
        basketFoodRepository.save(currentBasketFood);

        return userRepository.save(currentUser);
    }

//    public User addExtraIngredient(Integer id, Integer ingredientId) {
//        BasketFood currentBasketFood = basketFoodRepository.findBasketFoodById(id);
//        User currentUser = currentBasketFood.getOwner();
//        Ingredient currentIngredient = ingredientRepository.findIngredientById(ingredientId);
//        List<Ingredient> extraIngredients = currentBasketFood.getExtraIngredient();
//        Integer currentPrice = currentUser.getBasketPrice();
//
//        extraIngredients.add(currentIngredient);
//        currentPrice += currentIngredient.getPrice();
//        currentUser.setBasketPrice(currentPrice);
//        currentBasketFood.setExtraIngredient(extraIngredients);
//        basketFoodRepository.save(currentBasketFood);
//
//        return userRepository.save(currentUser);
//    }
//
//    public String deleteExtraIngredient(Integer id, Integer ingredientId) {
//        BasketFood currentBasketFood = basketFoodRepository.findBasketFoodById(id);
//        User currentUser = currentBasketFood.getOwner();
//        Ingredient currentIngredient = ingredientRepository.findIngredientById(ingredientId);
//        List<Ingredient> extraIngredients = currentBasketFood.getExtraIngredient();
//        Integer currentPrice = currentUser.getBasketPrice();
//
//        extraIngredients.remove(currentIngredient);
//        currentPrice -= currentIngredient.getPrice();
//        currentUser.setBasketPrice(currentPrice);
//        currentBasketFood.setExtraIngredient(extraIngredients);
//        basketFoodRepository.save(currentBasketFood);
//        userRepository.save(currentUser);
//
//        return "deleted";
//    }

    /**
     * Delete food from a user's basket.
     *
     * @param id     the id of the food
     * @param userId the id of the user
     * @return message on success
     */
    public String deleteFoodFromBasket(Integer id, Integer userId) {
        BasketFood currentBasketFood = basketFoodRepository.findBasketFoodById(id);
        User currentUser = userRepository.findUserById(userId);
        Integer currentPrice = currentUser.getBasketPrice();
        List<BasketFood> foods = currentUser.getBasket();


        foods.remove(currentBasketFood);
        currentUser.setBasket(foods);
        currentPrice -= currentBasketFood.getPrice();
        currentUser.setBasketPrice(currentPrice);
        userRepository.save(currentUser);
        basketFoodRepository.delete(currentBasketFood);

        return currentBasketFood.getName() + " deleted";
    }
}
