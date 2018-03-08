package upm.etsiinf.daw.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import upm.etsiinf.daw.security.UserInfo;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public ModelAndView home() {
		UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return new ModelAndView("home")
				.addObject("user", userInfo.getName())
				.addObject("home", "true");
	}
}
