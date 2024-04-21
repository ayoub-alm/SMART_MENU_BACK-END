package ma.smartMenu.smartmenu.dto;

import jakarta.persistence.*;
import lombok.*;
import ma.smartMenu.smartmenu.model.Product;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductCategoryDto {
    public String name;
    public String icon;
    public String description;
}
