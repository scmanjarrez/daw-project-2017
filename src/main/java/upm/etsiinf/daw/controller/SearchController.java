package upm.etsiinf.daw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import upm.etsiinf.daw.model.Movie;
import upm.etsiinf.daw.repository.MovieRepository;

import java.util.List;

/**
 * Created by S on 23/05/2017.
 */
@Controller
public class SearchController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/buscar")
    public ModelAndView search(@RequestParam("search") String search){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        //https://api.themoviedb.org/3/search/movie?api_key=b1c525b078e1a68db4167684e9ce2bd9&query=Tron
        List<Movie> listMovies = movieRepository.findByTitleContainingIgnoreCase(search);
        return new ModelAndView("search")
                .addObject("movies", listMovies)
                .addObject("user", name);
    }
}
