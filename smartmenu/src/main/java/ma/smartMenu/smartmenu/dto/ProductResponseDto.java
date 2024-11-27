package ma.smartMenu.smartmenu.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import ma.smartMenu.smartmenu.model.Ingredient;
import ma.smartMenu.smartmenu.model.Product;
import ma.smartMenu.smartmenu.model.ProductImage;
import ma.smartMenu.smartmenu.model.Seller;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    public String name;
    public String description;
    public Long categoryId;
    public String sku;
    public UUID ref;
    public Float price;
    public boolean state = true;
    public SellerResponseDto seller;
    public Set<Ingredient> ingredients;
    public List<ProductImage> images;

    public ProductResponseDto(Product product) {
        this.name = product.name;
        this.description = product.description;
        this.sku = product.sku;
        this.ref = product.ref;
        this.categoryId = product.category.getId();
        this.seller = new SellerResponseDto(product.category.getId(), product.seller.getSellerName());
        this.state = product.state;
        this.price = product.price;
        this.ingredients = product.ingredients;
        this.images = product.getImages();
    }
}
