package com.cdl.repository;

import org.springframework.stereotype.Repository;
import com.cdl.model.FacilityBooking;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface FacilityBookingRepository extends JpaRepository<FacilityBooking, Integer>{
	
	
	@Query(name = "select * from tb_facility_booking where user = :user", nativeQuery = true)
	public List<FacilityBooking> findByUser(@Param("user") String user);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query(name = "select * from tb_facility_booking where facility = :facility and starttime < :endtime and endtime > :starttime", nativeQuery = true)
	public List<FacilityBooking> findByFacilityStartTimeAndEndTime(@Param("facility") String facility, @Param("starttime") LocalDateTime startTime, 
			@Param("endtime") LocalDateTime endTime);

}
