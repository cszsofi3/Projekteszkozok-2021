package hu.projekteszkozok.food.security;


import hu.projekteszkozok.food.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
@Data
@NoArgsConstructor
public class AuthenticatedUser {
    private User user;
}
