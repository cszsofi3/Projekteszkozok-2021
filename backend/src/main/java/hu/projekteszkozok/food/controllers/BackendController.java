package hu.projekteszkozok.food.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.projekteszkozok.food.repositories.UserRepository;

@Controller
@RequestMapping("/api")
public class BackendController {
    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping(path = "/home")
    public String home() {
        LOG.info("GET called on /home resource");
        return "welcome home";
    }

    @ResponseBody
    @RequestMapping(path = "/products")
    public String products(@RequestParam("productList") String data) {
        LOG.info("GET called on /products resource");
        return "order data collected";
    }

    @ResponseBody
    @RequestMapping(value = "/allproducts", method = RequestMethod.POST)
    public UserRepository allproducts() {
        return this.userRepository;
    }

    
}
