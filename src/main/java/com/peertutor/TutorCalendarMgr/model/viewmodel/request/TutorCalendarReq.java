package com.peertutor.TutorCalendarMgr.model.viewmodel.request;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
public class TutorCalendarReq {
	@NotNull
    @NotEmpty
    public String name;

    @NotNull
    @NotEmpty
    public String sessionToken;
    
    public Long id;

	public Long tutorID;

	public Date  availableDate;
	
	public Timestamp startTime;
	
	public Timestamp endTime;
}
