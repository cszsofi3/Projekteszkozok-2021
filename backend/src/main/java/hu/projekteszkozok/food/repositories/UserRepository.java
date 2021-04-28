package hu.projekteszkozok.food.repositories;

import hu.projekteszkozok.food.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface User repository.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAll();

    /**
     * Find user by id.
     *
     * @param id the id of the user
     * @return the user
     */
    User findUserById(Integer id);
}
