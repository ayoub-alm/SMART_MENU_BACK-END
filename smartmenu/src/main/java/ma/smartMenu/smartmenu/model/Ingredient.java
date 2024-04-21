package ma.smartMenu.smartmenu.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.Set;


@Entity
@Builder
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String description;

    private String icon;
    @JsonBackReference
    @Column(nullable = true)
    @ManyToMany(mappedBy = "ingredients")
    private Set<Product> products;

    public Ingredient(Long id, String name, String description, String icon, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.products = products;
    }

    public Ingredient() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
