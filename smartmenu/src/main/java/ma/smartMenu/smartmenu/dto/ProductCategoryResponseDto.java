package ma.smartMenu.smartmenu.dto;

import lombok.*;
import ma.smartMenu.smartmenu.model.ProductCategory;

import java.util.UUID;

@Builder
@NoArgsConstructor
@Getter @Setter
public class ProductCategoryResponseDto {
    public Long id;
    public String name;
    public String icon;
    public UUID ref;
    public String description;

    public ProductCategoryResponseDto(Long id, String name, String icon,UUID ref, String description) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.ref = ref;
        this.description = description;
    }

    public ProductCategoryResponseDto(ProductCategory productCategory) {
        this.id = productCategory.getId();
        this.name = productCategory.getName();
        this.icon = productCategory.getIcon();
        this.ref = productCategory.getRef();
        this.description = productCategory.getDescription();
    }
}
