package upm.etsiinf.daw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import upm.etsiinf.daw.model.User;
import upm.etsiinf.daw.repository.UserRepository;

import java.util.Arrays;

/**
 * Created by S on 23/05/2017.
 */
@Controller
public class AdminUsersController {
    @Autowired
    private UserRepository userRepository;

    @Secured("ROLE_ADMIN")
    @GetMapping({"/admin", "/admin/users"})
    public ModelAndView adminUsers(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return new ModelAndView("adminusers")
                .addObject("user", name);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/admin/users")
    public ModelAndView adminAddUser(@RequestParam("username") String username,
                                     @RequestParam("email") String email,
                                     @RequestParam("password") String password,
                                     @RequestParam("passwordChk") String passwordChk,
                                     @RequestParam("role") String role,
                                     RedirectAttributes redirectAttributes){
        User user = userRepository.findByUsername(username);
        if (user == null){
            if (!password.equals(passwordChk)){
                redirectAttributes.addFlashAttribute("passDoesNotMatch", true);
                return new ModelAndView("redirect:/admin/users?add");
            }
            GrantedAuthority[] userRoles;
            if (role.equals("user")){
                userRoles = new GrantedAuthority[]{new SimpleGrantedAuthority("ROLE_USER")};
            } else {
                userRoles = new GrantedAuthority[]{new SimpleGrantedAuthority("ROLE_ADMIN")};
            }
            user = new User(username, password, email, Arrays.asList(userRoles));
            userRepository.save(user);
        } else {
            redirectAttributes.addFlashAttribute("alreadyCreated", true);
            return new ModelAndView("redirect:/admin/users?add");
        }
        redirectAttributes.addFlashAttribute("created", true);
        return new ModelAndView("redirect:/admin/users?add");
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/admin/users")
    public ModelAndView adminModifyUser(@RequestParam("username") String username,
                                        @RequestParam(name = "email", required = false) String email,
                                        @RequestParam(name = "password", required = false) String password,
                                        @RequestParam(name = "passwordChk", required = false) String passwordChk,
                                        @RequestParam(name = "role", required = false) String role,
                                        RedirectAttributes redirectAttributes){
        User user = userRepository.findByUsername(username);
        if (user != null){
            if (role != null && !role.isEmpty()) {
                GrantedAuthority[] userRoles;
                if (role.equals("user")) {
                    userRoles = new GrantedAuthority[]{new SimpleGrantedAuthority("ROLE_USER")};
                } else {
                    userRoles = new GrantedAuthority[]{new SimpleGrantedAuthority("ROLE_ADMIN")};
                }
                user.setRoles(Arrays.asList(userRoles));
            }

            if (email != null && !email.isEmpty()){
                user.setEmail(email);
            }

            if (password != null && !password.isEmpty()){
                if (passwordChk != null && !passwordChk.isEmpty() && password.equals(passwordChk)){
                    user.setPassword(password);
                } else {
                    redirectAttributes.addFlashAttribute("passDoesNotMatch", true);
                    return new ModelAndView("redirect:/admin/users?mod");
                }

            }
            userRepository.delete(user);
            userRepository.save(user);
            redirectAttributes.addFlashAttribute("modified", true);
            return new ModelAndView("redirect:/admin/users?mod");
        }
        redirectAttributes.addFlashAttribute("userDoesNotExist", true);
        return new ModelAndView("redirect:/admin/users?mod");
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/admin/users")
    public ModelAndView adminDeleteUser(@RequestParam("username") String username,
                                        RedirectAttributes redirectAttributes){
        User user = userRepository.findByUsername(username);
        if (user == null){
            redirectAttributes.addFlashAttribute("userDoesNotExist", true);
            return new ModelAndView("redirect:/admin/users?del");
        }
        userRepository.delete(user);
        redirectAttributes.addFlashAttribute("removed", true);
        return new ModelAndView("redirect:/admin/users?del");
    }
}
