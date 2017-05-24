package upm.etsiinf.daw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import upm.etsiinf.daw.model.Movie;
import upm.etsiinf.daw.model.User;
import upm.etsiinf.daw.repository.MovieRepository;
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
    private MovieRepository movieRepository;

    @PostConstruct
    private void initDatabase(){
        User user = userRepository.findByUsername("admin");
        if (user == null){
            GrantedAuthority[] userRoles = {new SimpleGrantedAuthority("ROLE_ADMIN")};
            userRepository.save(new User("admin", "admin", "admin@admin.com", Arrays.asList(userRoles)));
        }

        user = userRepository.findByUsername("user");
        if (user == null){
            GrantedAuthority[] userRoles = {new SimpleGrantedAuthority("ROLE_USER")};
            userRepository.save(new User("user", "user", "user@user.com", Arrays.asList(userRoles)));
        }

        Movie movie = movieRepository.findByTitle("Average man");
        if (movie == null){
            movieRepository.save(new Movie("Average man","https://www.youtube.com/embed/TuP1chV24jo"));
        }

        movie = movieRepository.findByTitle("Movie 1");
        if (movie == null){
            movieRepository.save(
                    new Movie("Movie 1", "https://www.youtube.com/embed/dQw4w9WgXcQ"));
        }

        movie = movieRepository.findByTitle("Goodbye Lenin");
        if (movie == null){
            movieRepository.save(
                    new Movie("Goodbye Lenin","https://www.youtube.com/embed/ZH8o68Yrwbc"));
        }

        movie = movieRepository.findByTitle("Letters From Iwo Jima");
        if (movie == null){
            movieRepository.save(
                    new Movie("Letters From Iwo Jima","https://www.youtube.com/embed/jVwjRC6Ncto"));
        }

        movie = movieRepository.findByTitle("Otoko-tachi no Yamato");
        if (movie == null){
            movieRepository.save(
                    new Movie("Otoko-tachi no Yamato","https://www.youtube.com/embed/BA2bEXTnigc"));
        }
    }
}
