package hu.projekteszkozok.food.repositories;

import hu.projekteszkozok.food.entities.Basket;
import org.springframework.data.repository.CrudRepository;


public interface BasketRepository extends CrudRepository<Basket, Integer> {

    Basket findByUserId(Integer id);

}
