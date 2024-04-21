package ma.smartMenu.smartmenu.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String sellerName;
    public String lat;
    public String lang;
    @OneToMany(mappedBy = "seller")
    List<Product> products;
    @ManyToOne()
    public User user;
}
