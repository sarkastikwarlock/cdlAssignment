package com.cdl.model;

import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_facility_booking")
public class FacilityBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String id;
	
	@Column(name = "facility")
	private String facility;
	
	@Column(name = "user")
	private String user;
	
	@Column(name = "starttime")
	private LocalDateTime startTime;
	
	@Column(name = "endtime")
	private LocalDateTime endTime;
	
	public FacilityBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FacilityBooking(String facility, String user, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.facility = facility;
		this.user = user;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	
	
	
}
