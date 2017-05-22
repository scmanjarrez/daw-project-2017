package upm.etsiinf.daw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import upm.etsiinf.daw.model.Role;
import upm.etsiinf.daw.model.User;
import upm.etsiinf.daw.repository.RoleRepository;
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
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostConstruct
    private void initDatabase(){
        Role role = roleRepository.findByRole("ADMIN");
        if (role == null){
            Role nrole = new Role();
            nrole.setRole("ADMIN");
            roleRepository.save(nrole);
        }
        role = roleRepository.findByRole("USER");
        if (role == null){
            Role nrole = new Role();
            nrole.setRole("USER");
            roleRepository.save(nrole);
        }
        User user = userRepository.findByUser("admin");
        System.out.println(user);
        if (user == null){
            User nuser = new User();
            nuser.setUser("admin");
            nuser.setEmail("admin@admin.com");
            nuser.setActive(1);
            nuser.setPassword(bCryptPasswordEncoder.encode("admin"));
            Role nuserRole = roleRepository.findByRole("ADMIN");
            nuser.setRoles(new HashSet<Role>(Arrays.asList(nuserRole)));
            userRepository.save(nuser);
        }
    }
}
