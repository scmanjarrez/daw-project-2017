package upm.etsiinf.daw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import upm.etsiinf.daw.model.Movie;
import upm.etsiinf.daw.repository.MovieRepository;
import upm.etsiinf.daw.rest.MovieTMDB;
import upm.etsiinf.daw.rest.SearchTMDB;
import upm.etsiinf.daw.security.UserInfo;

import java.util.List;

/**
 * Created by S on 23/05/2017.
 */
@Controller
public class SearchController {
    @Autowired
    private MovieRepository movieRepository;

    final private String api_key = "b1c525b078e1a68db4167684e9ce2bd9";
    final private String api_url = "https://api.themoviedb.org/3/search/movie?";
    final private String api_image = "https://image.tmdb.org/t/p/w300";

    @GetMapping("/buscar")
    public ModelAndView search(@RequestParam("search") String search){
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Movie> listMovies = movieRepository.findByTitleContainingIgnoreCase(search);

        if (listMovies != null && !listMovies.isEmpty()) {
            RestTemplate restTemplate = new RestTemplate();
            for (Movie movie : listMovies) {
                String url = api_url + "api_key=" + api_key + "&query=" + movie.getTitle();
                SearchTMDB movieInfo = restTemplate.getForObject(url, SearchTMDB.class);
                if (movieInfo.getResults() != null && !movieInfo.getResults().isEmpty()) {
                    List<MovieTMDB> lMovies = movieInfo.getResults();
                    MovieTMDB mMovie = lMovies.get(0);

                    if (movie.getYear() == 0) {
                        if (mMovie.getYear() != null && !mMovie.getYear().isEmpty()) {
                            movie.setYear(Integer.parseInt(mMovie.getYear()));
                        }
                    }

                    if (movie.getDescription() == null || movie.getDescription().isEmpty()) {
                        if (mMovie.getOverview() != null && !mMovie.getOverview().isEmpty()) {
                            movie.setDescription(mMovie.getOverview());
                        }
                    }

                    if (movie.getCover() == null || movie.getCover().isEmpty()) {
                        if (mMovie.getPoster_path() != null && !mMovie.getPoster_path().isEmpty()) {
                            movie.setCover(api_image + mMovie.getPoster_path());
                        }
                    }

                    if (movie.getRating() == 0.0) {
                            movie.setRating(mMovie.getVote_average());
                    }

                    movieRepository.save(movie);
                }
            }
        }
        return new ModelAndView("search")
                .addObject("movies", listMovies)
                .addObject("user", userInfo.getName());
    }
}
