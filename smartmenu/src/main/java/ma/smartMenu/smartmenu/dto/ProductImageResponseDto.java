package ma.smartMenu.smartmenu.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class ProductImageResponseDto {
    private String path;
    private Long id;
    private String name;
    private Long productId;
    private String extension;
}
