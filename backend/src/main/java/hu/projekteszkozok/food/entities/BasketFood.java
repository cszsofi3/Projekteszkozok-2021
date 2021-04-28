package hu.projekteszkozok.food.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * The type Basket food.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class BasketFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    private User owner;

    @Column
    private String name;

    @Column
    private Integer price;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Ingredient> extraIngredient;
}
