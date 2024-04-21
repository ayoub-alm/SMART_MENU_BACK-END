package ma.smartMenu.smartmenu.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class SellerResponseDto {
    private Long id;
    public String sellerName;
}
