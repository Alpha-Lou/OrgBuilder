package org.launchcode.orgBuilder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController extends AbstractController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/findPerson", method = RequestMethod.GET)
	public String findPersonForm() {
		return "findPerson";
	}
	
}
