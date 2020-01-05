package com.cg.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.entity.Flight;
import com.cg.service.FlightService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestFlight {

	@Autowired
	private FlightService service;
	
	@Test
	public void testAddFlight() {
		Flight fl = new Flight();
		fl.setCarrier("Indigo");
		fl.setSource("Mumabi");
		fl.setDestination("Kolkata");
		fl.setDistance(1150);
		service.addFlight(fl);
	}
	
	@Test
	public void TestFetchAll() {
		List<Flight> flights = service.getList();
		for (Flight flight : flights) {
			System.out.println(flight);
		}
	}
	
	@Test
	public void TestGetFlight() {
		Flight fl = service.getFlight(1);
		System.out.println(fl);
	}
	
	
	@Test
	public void TestGetFlightByCarrier() {
		List<Flight> flights = service.getByCarrier("Indigo");
		for (Flight flight : flights) {
			System.out.println(flight);
		}
	}
	
	
}
