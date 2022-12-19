package pl.coderslab.charity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @Column(unique = true)
    private String email;

    @NotEmpty
    private String password;

    private int enabled;  //boolean

    @ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.MERGE)
//    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "users_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
