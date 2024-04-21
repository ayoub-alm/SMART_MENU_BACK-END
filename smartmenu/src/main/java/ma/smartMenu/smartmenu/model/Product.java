package ma.smartMenu.smartmenu.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Product {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String name;
    public String description;
    public String sku;
    public UUID ref;
    public Float price;
    public boolean state;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id")
    public ProductCategory category;
    @JsonBackReference
    @ManyToMany
    private Set<Order> orders  = new HashSet<>();
    @JsonBackReference
    @ManyToOne
    public Seller seller;
    @OneToMany(mappedBy = "id")
    public List<ProductImage> images;

    @ManyToMany
    @JoinTable(
            name = "product_ingredient",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    public Set<Ingredient> ingredients;
}
