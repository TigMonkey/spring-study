package springStudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * MainController
 * 
 * @author TigMonkey
 */
@Controller
public class MainController {
	
	/**
	 * url = "/"
	 * 
	 * @author TigMonkey
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Model model) {		
		return "index";
	}
	
}
