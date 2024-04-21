package ma.smartMenu.smartmenu.model;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Builder
@Table(name = "product_images")
@AllArgsConstructor
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path;

    @Column(name = "name")
    private String name;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "extension")
    private String extension;

    public ProductImage(Long id, String name, Long productId, String extension) {
        this.id = id;
        this.name = name;
        this.productId = productId;
        this.extension = extension;
    }

    public ProductImage() {

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
