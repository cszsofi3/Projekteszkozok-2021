package hu.projekteszkozok.food.services;

import hu.projekteszkozok.food.entities.Food;
import hu.projekteszkozok.food.entities.User;
import hu.projekteszkozok.food.repositories.FoodRepository;
import hu.projekteszkozok.food.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FoodRepository foodRepository;

    public String deleteUser(Integer id) {
        User currentUser = userRepository.findUserById(id);
        userRepository.delete(currentUser);

        return currentUser.getName() + " deleted";
    }
    public User addFoodToBasket(Integer id, Integer userId) {
        Food currentFood = foodRepository.findFoodById(id);
        User currentUser = userRepository.findUserById(userId);
        List<Food> foods = currentUser.getBasket();

        foods.add(currentFood);
        currentUser.setBasket(foods);

        return userRepository.save(currentUser);
    }

        public String deleteFoodFromBasket(Integer id, Integer userId) {
        Food currentFood = foodRepository.findFoodById(id);
        User currentUser = userRepository.findUserById(userId);
        List<Food> foods = currentUser.getBasket();

        foods.remove(currentFood);
        currentUser.setBasket(foods);
        userRepository.save(currentUser);

        return currentFood.getName() + " deleted";
    }

}
