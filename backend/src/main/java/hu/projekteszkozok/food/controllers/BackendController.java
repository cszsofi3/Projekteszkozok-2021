package hu.projekteszkozok.food.controllers;
import hu.projekteszkozok.food.entities.Food;
import hu.projekteszkozok.food.entities.User;
import hu.projekteszkozok.food.repositories.FoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import hu.projekteszkozok.food.repositories.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/api")
public class BackendController {
    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FoodRepository foodRepository;

    @ResponseBody
    @RequestMapping(path = "/home")
    public String home() {
        LOG.info("GET called on /home resource");
        return "welcome home";
    }

    @ResponseBody
    @RequestMapping(value = "/products",  method = RequestMethod.GET)
    public String products(@RequestParam(value = "productList",required = false) Object data) {
        LOG.info("GET called on /products resource");
        if(data!=null) return "order data collected";
        else return "no data given";
    }

    @ResponseBody
    @RequestMapping(path = "/allproducts", method = RequestMethod.GET)
    public List<Food> allproducts() {
        return this.foodRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/allusers", method = RequestMethod.GET)
    public List<User> allusers() {
        return this.userRepository.findAll();
    }

    @ResponseBody
    @GetMapping(path = "/user/{id}")
    public User getUserById(@PathVariable("id") int id) throws RuntimeException {

        return this.userRepository.findById(id).map(user -> {
            LOG.info("Reading user with id " + id + " from database.");
            return user;
        }).orElseThrow(() -> new RuntimeException("user with id: " + id + " not found"));
    }
}
