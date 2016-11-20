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
		String prefix = request.getParameter("firstName");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("firstName");
		String suffix = request.getParameter("firstName");
		String phoneNumber = request.getParameter("firstName");
		String email = request.getParameter("firstName");
		String street = request.getParameter("firstName");
		String city = request.getParameter("firstName");
		String state = request.getParameter("firstName");
		String zipcode = request.getParameter("firstName");
		
		// lets make a person!
		if (firstName != null && lastName != null) {
			Person newPerson = new Person(firstName, lastName);
			if (prefix != null) {
				newPerson.setPrefix(prefix);
			}
			
			if (suffix != null) {
				newPerson.setSuffix(suffix);
			}
			
			if (phoneNumber != null) {
				//newPerson.setPhoneNumber(Integer.parseInt(phoneNumber));
			}
			
			if (email != null) {
				newPerson.setEmail(email);
			}
			
			if (street != null || city != null || state != null || zipcode != null) {
				Address address = new Address();
				
				if (street != null) {
					address.setStreet(street);
				}
				
				if (city != null) {
					address.setCity(city);
				}
				
				if (state != null) {
					address.setState(state);
				}
				
				if (zipcode != null) {
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

}
