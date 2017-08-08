package com.alexis.springhibernate.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexis.springhibernate.service.PassportService;
import com.alexis.springhibernate.service.TravelService;

@Controller
@RequestMapping("/travels")
public class TravelController {

	Logger logger = LoggerFactory.getLogger(TravelController.class);
	
	@Autowired
	private TravelService travelService;

	public void setTravelService(TravelService travelService) {
		this.travelService = travelService;
	}
	
	@RequestMapping("/travels/")
	public String listAllTravels(Model model) {
		
		logger.debug("listAllTravelsByPassport()");
		
		return "/travel/list";
	}

	
	
	
	
	
	
	
}