package ma.smartMenu.smartmenu.dto;

import lombok.*;

import java.sql.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private String addressId;
    private String emailAddress;
    private String password;
    private Boolean sex;
    private Date birthday;


}
