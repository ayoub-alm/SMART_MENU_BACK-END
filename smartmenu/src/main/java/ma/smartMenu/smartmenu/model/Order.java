package ma.smartMenu.smartmenu.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ma.smartMenu.smartmenu.enums.OrderState;
import ma.smartMenu.smartmenu.enums.OrderType;

import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "orders")
@Setter
@Getter
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double totalAmount;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "proceed_by_id")
    private User proceedBy;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;
    private UUID uuid;
    private OrderType orderType;
    private OrderState orderState;

}
