package com.peertutor.TutorCalendarMgr.model.viewmodel.response;

import  com.peertutor.TutorCalendarMgr.service.dto.TutorCalendarMgrDTO;
import java.sql.Date;
import java.sql.Timestamp;
import javax.validation.constraints.NotNull;


public class TutorCalendarRes {

	public Long id;

	public Long tutorID;

	public Date  availableDate;
	
	public Timestamp startTime;
	
	public Timestamp endTime;
    
	 public TutorCalendarRes(TutorCalendarMgrDTO tutorCalendarMgrDTO) {
		 	this.id = tutorCalendarMgrDTO.getId();
		 	this.tutorID = tutorCalendarMgrDTO.getTutorID();
		 	this.availableDate = tutorCalendarMgrDTO.getAvailableDate();
		 	this.startTime = tutorCalendarMgrDTO.getStartTime();
		 	this.endTime =tutorCalendarMgrDTO.getEndTime();
	    }

}
