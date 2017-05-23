package upm.etsiinf.daw.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by S on 14/05/2017.
 */
@Entity
public class User {
    @Id
    private String username;
    private String password;
    private String email;
    private int active;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<GrantedAuthority> roles;

    protected User() {
    }

    public User(String username, String password, String email, List<GrantedAuthority> roles) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.active = 1;
        this.email = email;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(List<GrantedAuthority> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", roles=" + roles +
                '}';
    }
}
