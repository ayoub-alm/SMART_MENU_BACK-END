package ma.smartMenu.smartmenu.dto;

import lombok.*;
import ma.smartMenu.smartmenu.enums.OrderState;
import ma.smartMenu.smartmenu.enums.OrderType;

import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class OrderDto {
    private Long id;
    private List<ProductDto> products;
    private UserDto user;
    private double totalAmount;
    private UUID uuid;
    private OrderType orderType;
    private OrderState orderState;
}
