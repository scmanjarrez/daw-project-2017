package upm.etsiinf.daw.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by S on 23/05/2017.
 */
@Controller
public class AdminUsersController {
    @Secured("ROLE_ADMIN")
    @GetMapping("/admin/users")
    public ModelAndView adminUsers(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return new ModelAndView("adminusers")
                .addObject("user", name);
    }
}
