package hu.projekteszkozok.food.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String type;

    @OneToMany(mappedBy = "food")
    private List<Ingredient> ingredientList;

//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name="userId", nullable = false)
//    private User user;
}
