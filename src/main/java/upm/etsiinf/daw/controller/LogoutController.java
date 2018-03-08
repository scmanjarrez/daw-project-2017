package upm.etsiinf.daw.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by S on 23/05/2017.
 */
@Controller
public class LogoutController {
    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)){
            new SecurityContextLogoutHandler().logout(request, response, auth);
            //return new ModelAndView("redirect:/logout");
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://localhost:8080");
            return redirectView;
        }
        //return new ModelAndView("redirect:/login");
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/login");
        return redirectView;
    }
}
