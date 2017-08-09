package com.alexis.springhibernate.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alexis.springhibernate.model.Travel;
import com.alexis.springhibernate.service.CountryService;
import com.alexis.springhibernate.service.TravelService;

@Controller
@RequestMapping("/travels")
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


	@RequestMapping(value="/persons/{passportId}/addTravel", method = RequestMethod.GET)
	public String addTravel(@PathVariable int passportId, Model model) {
		
		logger.debug("addTravel()");
		
		model.addAttribute("countries" , countryService.getAllCountries());
		model.addAttribute("passportId", passportId);
		
		return "/persons/travelForm";
		
	}
	
	@RequestMapping(value="/persons/{passportId}/saveTravel", method = RequestMethod.GET)
	public String saveTravel(@ModelAttribute("travelForm") Travel travel, @PathVariable int idPassport ) {
		
		logger.debug("saveTravel()");
		
		travelService.persisteTravel(travel);
		
		return "/persons/{" + idPassport + "}/passport";
		
	}
	
	
}
