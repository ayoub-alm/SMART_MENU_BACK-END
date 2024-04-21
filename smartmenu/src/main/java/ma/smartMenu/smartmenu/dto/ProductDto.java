package ma.smartMenu.smartmenu.dto;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    public String name;
    public String description;
    public Long categoryId;
    public String sku;
    public Float price;
    public boolean state = true;
    public Long sellerId;
    public List<MultipartFile> img;
}
