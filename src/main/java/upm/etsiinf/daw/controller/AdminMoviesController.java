package upm.etsiinf.daw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import upm.etsiinf.daw.model.Movie;
import upm.etsiinf.daw.repository.MovieRepository;

import java.util.Arrays;

/**
 * Created by S on 23/05/2017.
 */
@Controller
public class AdminMoviesController {
    @Autowired
    private MovieRepository movieRepository;

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin/movies")
    public ModelAndView adminUsers(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return new ModelAndView("adminmovies")
                .addObject("user", name);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/admin/movies")
    public ModelAndView adminAddMovie(@RequestParam("title") String title,
                                     @RequestParam("url") String url,
                                     @RequestParam(name = "description", required = false) String description,
                                     @RequestParam(name = "year", required = false) String year,
                                     @RequestParam(name = "director", required = false) String director,
                                     @RequestParam(name = "cast", required = false) String cast,
                                     @RequestParam(name = "cover", required = false) String cover,
                                     @RequestParam(name = "rating", required = false) String rating,
                                     RedirectAttributes redirectAttributes){
        Movie movie = movieRepository.findByTitle(title);
        if (movie == null){
            movie = new Movie(title, url);
            if (description != null && !description.isEmpty()){
                movie.setDescription(description);
            }
            if (year != null && !year.isEmpty()){
                movie.setYear(Integer.parseInt(year));
            }
            if (director != null && !director.isEmpty()){
                movie.setDirector(director);
            }
            if (cast != null && !cast.isEmpty()){
                movie.setCast(cast);
            }
            if (cover != null && !cover.isEmpty()){
                movie.setCover(cover);
            }
            if (rating != null && !rating.isEmpty()){
                movie.setRating(Float.parseFloat(rating));
            }
            movieRepository.save(movie);
        } else {
            redirectAttributes.addFlashAttribute("alreadyAdded", true);
            return new ModelAndView("redirect:/admin/movies?add");
        }
        redirectAttributes.addFlashAttribute("added", true);
        return new ModelAndView("redirect:/admin/movies?add");
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/admin/movies")
    public ModelAndView adminAModifyMovie(@RequestParam("title") String title,
                                     @RequestParam(name = "url", required = false) String url,
                                     @RequestParam(name = "description", required = false) String description,
                                     @RequestParam(name = "year", required = false) String year,
                                     @RequestParam(name = "director", required = false) String director,
                                     @RequestParam(name = "cast", required = false) String cast,
                                     @RequestParam(name = "cover", required = false) String cover,
                                     @RequestParam(name = "rating", required = false) String rating,
                                     RedirectAttributes redirectAttributes){
        Movie movie = movieRepository.findByTitle(title);
        if (movie != null){
            if (url != null && !url.isEmpty()){
                movie.setUrl(url);
            }
            if (description != null && !description.isEmpty()){
                movie.setDescription(description);
            }
            if (year != null && !year.isEmpty()){
                movie.setYear(Integer.parseInt(year));
            }
            if (director != null && !director.isEmpty()){
                movie.setDirector(director);
            }
            if (cast != null && !cast.isEmpty()){
                movie.setCast(cast);
            }
            if (cover != null && !cover.isEmpty()){
                movie.setCover(cover);
            }
            if (rating != null && !rating.isEmpty()){
                movie.setRating(Float.parseFloat(rating));
            }
            movieRepository.save(movie);
            redirectAttributes.addFlashAttribute("modified", true);
            return new ModelAndView("redirect:/admin/movies?mod");
        }
        redirectAttributes.addFlashAttribute("movieDoesNotExist", true);
        return new ModelAndView("redirect:/admin/movies?mod");
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/admin/movies")
    public ModelAndView adminDeleteMovie(@RequestParam("title") String title,
                                        RedirectAttributes redirectAttributes){
        Movie movie = movieRepository.findByTitle(title);
        if (movie == null){
            redirectAttributes.addFlashAttribute("movieDoesNotExist", true);
            return new ModelAndView("redirect:/admin/movies?del");
        }
        movieRepository.delete(movie);
        redirectAttributes.addFlashAttribute("removed", true);
        return new ModelAndView("redirect:/admin/movies?del");
    }
}
