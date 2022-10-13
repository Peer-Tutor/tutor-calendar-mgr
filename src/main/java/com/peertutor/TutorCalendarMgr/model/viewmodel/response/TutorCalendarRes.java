package com.peertutor.TutorCalendarMgr.model.viewmodel.response;

import java.sql.Date;
import java.util.List;


public class TutorCalendarRes {
	public List<Date> availableDate;

	public TutorCalendarRes(List<Date> availableDate) {
		this.availableDate = availableDate;
	}
}
