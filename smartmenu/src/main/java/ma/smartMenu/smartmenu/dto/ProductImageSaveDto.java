package ma.smartMenu.smartmenu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Builder
@Getter @Setter
@AllArgsConstructor
public class ProductImageSaveDto {
    public Long productId;
    public List<MultipartFile> img;
}