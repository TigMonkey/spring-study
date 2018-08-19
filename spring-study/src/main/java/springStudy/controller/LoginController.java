package springStudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * LoginController
 * 
 * @author TigMonkey
 */
@Controller
public class LoginController {

	/**
	 * url : "/login"
	 * 
	 * @author TigMonkey
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(Model model) {
		return "";
	}
	
}
