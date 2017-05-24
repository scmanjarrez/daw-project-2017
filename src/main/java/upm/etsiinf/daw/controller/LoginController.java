package upm.etsiinf.daw.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    @GetMapping({"/", "/login"})
    public ModelAndView index(@RequestParam(value = "logout", required = false) String logout,
                              @RequestParam(value = "error", required = false) String error,
                              RedirectAttributes redirectAttributes){
        if (logout != null && logout.isEmpty()){
            redirectAttributes.addFlashAttribute("logout", true);
            return new ModelAndView("redirect:/login");
        }

        if (error != null && error.isEmpty()){
            redirectAttributes.addFlashAttribute("error", true);
            return new ModelAndView("redirect:/login");
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)){
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("login")
                .addObject("login", "true");
    }
}
