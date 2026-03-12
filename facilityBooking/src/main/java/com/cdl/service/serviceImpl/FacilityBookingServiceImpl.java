package com.cdl.service.serviceImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdl.model.FacilityBooking;
import com.cdl.repository.FacilityBookingRepository;
import com.cdl.service.FacilityBookingService;

@Service
@Transactional
public class FacilityBookingServiceImpl implements FacilityBookingService{
	
	@Autowired
	public FacilityBookingRepository facilityBookingRepository;

	@Override
	public List<FacilityBooking> findFacilityBookingByUser(String user) {
		// TODO Auto-generated method stub
		List<FacilityBooking> list = facilityBookingRepository.findByUser(user);
		return null;
	}

	@Override
	public List<FacilityBooking> findFacilityBookingByFacilityStartTimeAndEndTime(String facility, LocalDateTime startTime, LocalDateTime endTime) {
		// TODO Auto-generated method stub
		List<FacilityBooking> list = facilityBookingRepository.findByFacilityStartTimeAndEndTime(facility, startTime, endTime);
		return null;
	}

	@Override
	public FacilityBooking createBooking(FacilityBooking facilityBooking) {
		// TODO Auto-generated method stub
		
		if(facilityBooking.getStartTime().isAfter(facilityBooking.getEndTime())) {
			throw new RuntimeException("Start time cannot be after End time.");
		}
		
		if(facilityBooking.getEndTime().isBefore(facilityBooking.getStartTime())) {
			throw new RuntimeException("End time cannot be before Start time.");
		}
		
		long hours = Duration.between(facilityBooking.getStartTime(), facilityBooking.getEndTime()).toHours();
		
		if(hours>2) {
			throw new RuntimeException("Maximum booking duration is 2 hours.");
		}
		
		List<FacilityBooking> conflicts = facilityBookingRepository.findByFacilityStartTimeAndEndTime(facilityBooking.getFacility(), facilityBooking.getStartTime(), 
				facilityBooking.getEndTime());
		
		if(!conflicts.isEmpty()) {
			throw new RuntimeException("There is already an existing booking.");
		}
		
		return facilityBookingRepository.save(facilityBooking);
	}

}
