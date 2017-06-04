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

        Movie movie = movieRepository.findByTitle("DeadPool");
        if (movie == null){
            movieRepository.save(new Movie("DeadPool","https://www.youtube.com/embed/FyKWUTwSYAs"));
        }

        movie = movieRepository.findByTitle("Hamlet");
        if (movie == null){
            movieRepository.save(
                    new Movie("Hamlet", "https://www.youtube.com/embed/-rd74Gniz-A"));
        }

        movie = movieRepository.findByTitle("La chica danesa");
        if (movie == null){
            movieRepository.save(
                    new Movie("La chica danesa","https://www.youtube.com/embed/ENiuBpdrnZ8"));
        }

        movie = movieRepository.findByTitle("Letters From Iwo Jima");
        if (movie == null){
            movieRepository.save(
                    new Movie("Letters From Iwo Jima","https://www.youtube.com/embed/51lo2dpaZ_g"));
        }

        movie = movieRepository.findByTitle("Otoko-tachi no Yamato");
        if (movie == null){
            movieRepository.save(
                    new Movie("Otoko-tachi no Yamato","https://www.youtube.com/embed/q4QWqDTCk2A"));
        }

        movie = movieRepository.findByTitle("Alien: Covenant");
        if (movie == null){
            movieRepository.save(
                    new Movie("Alien: Covenant","https://www.youtube.com/embed/svnAD0TApb8"));
        }

        movie = movieRepository.findByTitle("Piratas del Caribe 5");
        if (movie == null){
            movieRepository.save(
                    new Movie("Piratas del Caribe 5","https://www.youtube.com/watch?v=IPf4rGw3XHw"));
        }

        movie = movieRepository.findByTitle("Guardianes de la Galaxia 2");
        if (movie == null){
            movieRepository.save(
                    new Movie("Guardianes de la Galaxia 2","https://www.youtube.com/embed/12gvJgLE4us"));
        }

        movie = movieRepository.findByTitle("Déjame salir");
        if (movie == null){
            movieRepository.save(
                    new Movie("Déjame salir","https://www.youtube.com/embed/X-tg05cAVwE"));
        }

        movie = movieRepository.findByTitle("Fast & Furious 8");
        if (movie == null){
            movieRepository.save(
                    new Movie("Fast & Furious 8","https://www.youtube.com/embed/uisBaTkQAEs"));
        }
    }
}
