package com.cdl.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cdl.model.FacilityBooking;

public interface FacilityBookingService {

	public List<FacilityBooking> findFacilityBookingByUser(String user);
		
	public List<FacilityBooking> findFacilityBookingByFacilityStartTimeAndEndTime(String facility, LocalDateTime startTime, LocalDateTime endTime);
	
	public FacilityBooking createBooking(FacilityBooking facilityBooking);
}
