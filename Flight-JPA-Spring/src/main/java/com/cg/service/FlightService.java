package com.cg.service;

import java.util.List;

import com.cg.entity.Flight;

public interface FlightService {
	
	int addFlight(Flight flight);
	
	Flight getFlight(int id);
	
	List<Flight> getList();
	
	List<Flight> getByCarrier(String carrier);
	
}
