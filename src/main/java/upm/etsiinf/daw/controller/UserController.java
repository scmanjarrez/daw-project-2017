package upm.etsiinf.daw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import upm.etsiinf.daw.model.User;
import upm.etsiinf.daw.repository.UserRepository;
import upm.etsiinf.daw.security.UserInfo;

/**
 * Created by S on 24/05/2017.
 */
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/info")
    public ModelAndView getInfo(){
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ModelAndView("userinfo")
                .addObject("userObj", userInfo)
                .addObject("user", userInfo.getName());
    }
}
