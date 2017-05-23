package upm.etsiinf.daw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import upm.etsiinf.daw.model.User;
import upm.etsiinf.daw.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by S on 22/05/2017.
 */
@Component
public class DatabaseLoader {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initDatabase(){
        User user = userRepository.findByUsername("admin");
        if (user == null){
            GrantedAuthority[] userRoles = {new SimpleGrantedAuthority("ROLE_ADMIN")};
            userRepository.save(new User("admin", "admin", "admin@admin.com", Arrays.asList(userRoles)));
        }
    }
}
