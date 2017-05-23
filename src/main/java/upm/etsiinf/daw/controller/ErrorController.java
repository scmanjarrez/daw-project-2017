package upm.etsiinf.daw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by S on 23/05/2017.
 */
@Controller
public class ErrorController {
    @GetMapping("/error")
    public ModelAndView error(){
        return new ModelAndView("error");
    }
}
