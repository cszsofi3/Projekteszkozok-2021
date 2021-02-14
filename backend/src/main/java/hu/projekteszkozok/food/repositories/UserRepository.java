package hu.projekteszkozok.food.repositories;

import hu.projekteszkozok.food.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
