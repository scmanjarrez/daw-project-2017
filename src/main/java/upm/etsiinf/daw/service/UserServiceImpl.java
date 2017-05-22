package upm.etsiinf.daw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import upm.etsiinf.daw.model.Role;
import upm.etsiinf.daw.model.User;
import upm.etsiinf.daw.repository.RoleRepository;
import upm.etsiinf.daw.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by S on 18/05/2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public void subscribeUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        User aux = userRepository.findByEmail(user.getEmail());
        userRepository.delete(aux);
    }

    @Override
    public void unsubscribeUser(User user) {
        User aux = userRepository.findByEmail(user.getEmail());
        aux.setActive(0);
        userRepository.save(aux);
    }

    @Override
    public void modifyUser(User user){
        User aux = userRepository.findByEmail(user.getEmail());
        aux.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        aux.setUser(user.getUser());
        userRepository.save(aux);
    }
}
