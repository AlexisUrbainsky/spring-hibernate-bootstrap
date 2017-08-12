package com.alexis.springhibernate.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alexis.springhibernate.model.Country;
import com.alexis.springhibernate.model.Travel;
import com.alexis.springhibernate.service.CountryService;
import com.alexis.springhibernate.service.TravelService;

@Controller
@RequestMapping("/")
public class TravelController {

	Logger logger = LoggerFactory.getLogger(TravelController.class);
	
	@Autowired
	private TravelService travelService;

	@Autowired
	private CountryService countryService;
	
	public void setTravelService(TravelService travelService) {
		this.travelService = travelService;
	}
	
	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}


	@RequestMapping(value="/travels/{passportId}/addTravel", method = RequestMethod.GET)
	public String addTravel(@PathVariable int passportId, Model model) {
		
		logger.debug("addTravel()");
		
		Travel travel = new Travel();
		
		List<Country> countries = countryService.getAllCountries();
		travel.setPassportId(passportId);
		model.addAttribute("countries" , countries);
		model.addAttribute("travelForm", travel);
		
		return "/persons/travelForm";
		
	}
	
	@RequestMapping(value="/travels/saveTravel", method = RequestMethod.POST)
	public String saveTravel(@ModelAttribute("travelForm") Travel travel, Model model,final RedirectAttributes redirectAtributes,BindingResult result) {
		
		logger.debug("saveTravel()");
		
		travelService.persisteTravel(travel);
		
		return "redirect:/persons/{" + travel.getPassportId() + "}/passport";
		
	}
	
	
}
