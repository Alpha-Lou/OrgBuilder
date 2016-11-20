package org.launchcode.orgBuilder.controllers;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.orgBuilder.models.Address;
import org.launchcode.orgBuilder.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EntryController extends AbstractController {
	
	@RequestMapping(value = "/addPerson", method = RequestMethod.GET)
	public String newPersonForm() {
		return "addPerson";
	}
	
	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	public String newPerson(HttpServletRequest request, Model model) {
		
		// get all the arguments
		String prefix = request.getParameter("prefix");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String suffix = request.getParameter("suffix");
		String phoneNumber = request.getParameter("phone");
		String email = request.getParameter("email");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		
		// lets make a person!
		if (firstName != null && lastName != null) {
			Person newPerson = new Person(firstName, lastName);
			if (exists(prefix)) {
				newPerson.setPrefix(prefix);
			}
			
			if (exists(suffix)) {
				newPerson.setSuffix(suffix);
			}
			
			if (exists(phoneNumber)) {
				newPerson.setPhoneNumber(Integer.parseInt(phoneNumber));
			}
			
			if (exists(email)) {
				newPerson.setEmail(email);
			}
			
			if (exists(street) || exists(city) || exists(state) || exists(zipcode)) {
				Address address = new Address();
				
				if (exists(street)) {
					address.setStreet(street);
				}
				
				if (exists(city)) {
					address.setCity(city);
				}
				
				if (exists(state)) {
					address.setState(state);
				}
				
				if (exists(zipcode)) {
					address.setZipcode(zipcode);
				}
				
				addressDao.save(address);
				newPerson.getAddresses().add(address);
			}
			
			personDao.save(newPerson);
			
			model.addAttribute("error", "Person Added Succesfully!");
			return "addPerson";
			
		} else {
			
			model.addAttribute("error", "People need a first and last name at minimum");
			return "addPerson";
		}
		
	}

	@RequestMapping(value = "/addQuestion", method = RequestMethod.GET)
	public String newQuestionForm() {
		
		return "newQuestion";
	}
	
	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	public String newQuestion(HttpServletRequest request, Model model) {
		//String title = request.getParameter("title");
		
		return "newQuestion";
	}
	
	@RequestMapping(value = "/addTag", method = RequestMethod.GET)
	public String newTagForm() {
		
		return "newQuestion";
	}
	
	@RequestMapping(value = "/addTag", method = RequestMethod.POST)
	public String newTag(HttpServletRequest request, Model model) {
		
		return "newQuestion";
	}
}
