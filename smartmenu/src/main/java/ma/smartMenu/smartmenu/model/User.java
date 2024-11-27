package ma.smartMenu.smartmenu.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Setter
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    @Column(unique = true)
    private String emailAddress;
    private String addressId;
    private String ref;
    private String password;
    private String sex;
    @DateTimeFormat(pattern = "dd/MM/yy")
    private Date birthday;

    public User() {
    }

    public User(String name, String phoneNumber, String emailAddress, String addressId, String ref, String password, String sex, Date birthday) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.addressId = addressId;
        this.ref = ref;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
    }

}
