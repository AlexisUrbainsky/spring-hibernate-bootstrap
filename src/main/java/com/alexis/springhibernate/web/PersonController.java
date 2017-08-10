package com.alexis.springhibernate.web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alexis.springhibernate.model.Passport;
import com.alexis.springhibernate.model.Person;
import com.alexis.springhibernate.service.PersonService;
import com.alexis.springhibernate.validator.PersonFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/")
public class PersonController {
	
	private final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService personService;
	
	@Autowired
	PersonFormValidator personFormValidator;

	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setValidator(personFormValidator);
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model){
		logger.debug("/index");

		return "redirect:/persons";
	}
	
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String getAllPersons(Model model){
		logger.debug("getAllPersons()");
		
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons" , persons);
		
		return "/persons/list";
	}
	
	
	@RequestMapping(value = "/persons", method = RequestMethod.POST)
	public String saveUpdatePerson(@ModelAttribute("personForm") @Validated Person person, BindingResult result,
			final RedirectAttributes redirectAtributes, Model model ) {
		
		logger.debug("saveUpdatePerson()");
		
		if(result.hasErrors()) {
			return "redirect:/persons/add";
		}else{
			
			personService.persistePerson(person);
			
			return "redirect:/persons";
		}
		
	}
	
	
	@RequestMapping(value = "/persons/add", method = RequestMethod.GET)
	public String addPersonForm(Model model) {
		
		logger.debug("addPersonForm()");

		Date today 		= new Date(Calendar.getInstance().getTime().getDate());
		Calendar.getInstance().add(Calendar.DATE, 7);
		Date expirate	= new Date(Calendar.getInstance().getTime().getDate());
		
		Passport passport = new Passport("Argentinian", today, expirate);
		Person 	 person   = new Person("Alexis","Urbainsky","aurbainsky@gmail.com","M");

		person.setPassport(passport);
		model.addAttribute("personForm",person);
		
		return "/persons/personForm";
	}
	
	
	@RequestMapping(value = "/persons/{id}/delete", method = RequestMethod.POST)
	public String deletePerson(@PathVariable int id ,Model model,final RedirectAttributes redirectAttributes ) {
		
		logger.debug("deletePerson() Id: " + id);
		
		Person person = personService.findById(id);
		
		personService.deletePerson(person);
		
		redirectAttributes.addFlashAttribute("css", "Success");
		redirectAttributes.addFlashAttribute("msg", "Person is Deleted");
		
		return "redirect:/persons";
	}
	
	
	@RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
	public String showPerson(@PathVariable int id, Model model) {
		
		model.addAttribute(personService.findById(id));
		
		return "/persons/showPerson";
	}
	

	@RequestMapping(value = "/persons/{id}/passport", method = RequestMethod.GET)
	public String showPassport(@PathVariable int id, Model model) {
		
		Person person = personService.findById(id);
		
		model.addAttribute("person" ,person);

		return "/persons/passport";
	}
	
	
}
