package vitua.kotler.ai.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_surname")
    private String userSurname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    /**
     * Проверка, не истек ли срок действия аккаунта.
     *
     * @return всегда {@code true}, аккаунт всегда активен
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Проверка, не заблокирован ли аккаунт.
     *
     * @return всегда {@code true}, аккаунт не заблокирован
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Проверка, не истек ли срок действия учетных данных.
     *
     * @return всегда {@code true}, учетные данные всегда действительны
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Проверка, включен ли аккаунт.
     *
     * @return всегда {@code true}, аккаунт всегда включен
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
