package my.home.shop.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.home.shop.models.enums.UserRole;
import my.home.shop.models.enums.UserState;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 20)
    private String firstName;
    @Column(name = "last_name", length = 20)
    private String lastName;

    private Integer age;
    private String phone;
    private String email;
    private String login;
    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    @Enumerated(value = EnumType.STRING)
    private UserState state;

    private String confirmUUID;
}
