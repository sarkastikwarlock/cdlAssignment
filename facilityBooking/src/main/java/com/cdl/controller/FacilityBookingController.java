package com.cdl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cdl.model.FacilityBooking;
import com.cdl.service.FacilityBookingService;

@RestController
public class FacilityBookingController {
	
	@Autowired
	public FacilityBookingService facilityBookingService;

	@RequestMapping(name = "/userBooking", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<FacilityBooking>> getUserBooking(String user) {
		List<FacilityBooking> list = facilityBookingService.findFacilityBookingByUser(user);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	public ResponseEntity<String> createBooking(@RequestBody FacilityBooking facilityBooking){
		FacilityBooking booking = facilityBookingService.createBooking(facilityBooking);
		return new ResponseEntity<>("Booking saved", HttpStatus.OK);
		
	}
}
