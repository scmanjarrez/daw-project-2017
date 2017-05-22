package upm.etsiinf.daw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import upm.etsiinf.daw.model.User;
import upm.etsiinf.daw.repository.UserRepository;
import upm.etsiinf.daw.service.UserService;

import javax.validation.Valid;

/**
 * Created by S on 14/05/2017.
 */
@Controller
public class SecurityController {
    @Autowired
    private UserService userService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView( "login");
    }

    @RequestMapping(value="/admin/subscribe", method = RequestMethod.GET)
    public ModelAndView subscribeUser() {
        User user = new User();
        ModelAndView modelAndView = new ModelAndView("subscribe")
                .addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value="/admin/subscribe", method = RequestMethod.POST)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null){
            bindingResult.rejectValue("email", "error.user", "Ya existe un usuario con este correo.");
        }
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("subscribe");
        }else{
            userService.subscribeUser(user);
            modelAndView.addObject("successMessage", "Usuario creado correctamente.");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("subscribe");
        }
        return modelAndView;
    }

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getUser() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }
}
