package hu.projekteszkozok.food.repositories;

import hu.projekteszkozok.food.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAll();

    User findUserById(Integer id);
}
