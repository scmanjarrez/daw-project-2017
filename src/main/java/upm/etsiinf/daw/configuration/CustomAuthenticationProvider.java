//package upm.etsiinf.daw.configuration;
//
///**
// * Created by S on 23/05/2017.
// */
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//import upm.etsiinf.daw.model.User;
//import upm.etsiinf.daw.repository.UserRepository;
//
//import java.util.List;
//
//@Component
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = (String)authentication.getCredentials();
//        User user = userRepository.findByUsername(username);
//
//        if(user == null){
//            throw new BadCredentialsException("User not found");
//        }
//        if(!new BCryptPasswordEncoder().matches(password, user.getPassword())){
//            throw new BadCredentialsException("Wrong password");
//        }
//
//        List<GrantedAuthority> roles = user.getRoles();
//
//        return new UsernamePasswordAuthenticationToken(username, password, roles);
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        // Si no ponemos true mirar documentacion para distintos mecanismos error
//        return true;
//    }
//}

