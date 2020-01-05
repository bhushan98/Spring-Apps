package com.cg.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.entity.Flight;
import com.cg.service.FlightService;

@Controller
public class FlightController {
	
	@Autowired
	private FlightService service;
	
	
	@RequestMapping("/add.do")
	public String addFlight(Flight flight, Map model) {
		model.put("flight", flight);
		service.addFlight(flight);
		return "addout";
	}
	
	@RequestMapping("/find.do")
	public String searchFlight(int id, Map model) {
		Flight flight = service.getFlight(id);
		model.put("flight", flight);
		return "searchflight";
	}
	
	@RequestMapping("/all.do")
	public String fetchAll(Map model) {
		model.put("flights", service.getList());
		return "listall";
	}
}
