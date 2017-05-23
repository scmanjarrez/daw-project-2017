package upm.etsiinf.daw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by S on 23/05/2017.
 */
@Controller
public class SearchController {
    @GetMapping("/buscar")
    public ModelAndView search(@RequestParam("search") String search){
        //https://api.themoviedb.org/3/search/movie?api_key=b1c525b078e1a68db4167684e9ce2bd9&query=Tron
        System.out.println(search);
        return new ModelAndView("search");
    }
}
