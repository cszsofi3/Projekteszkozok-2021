package hu.projekteszkozok.food.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
    private String password;

//    @Column(nullable = false)
//    @JsonProperty(access = WRITE_ONLY)
//    private String email;
//
//    @Column(nullable = false)
//    @JsonProperty(access = WRITE_ONLY)
//    private String password;

//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private Role role;

    @Column
    private Integer basketPrice;

    @OneToMany(fetch = FetchType.LAZY)
    private List<BasketFood> basket;
}
