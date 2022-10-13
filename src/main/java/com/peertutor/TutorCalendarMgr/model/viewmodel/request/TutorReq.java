package com.peertutor.TutorCalendarMgr.model.viewmodel.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
public class TutorReq {
	@NotNull
	@NotEmpty
	public Long tutorId;

	public Long getTutorId() {
		return tutorId;
	}

	public void setTutorId(Long tutorId) {
		this.tutorId = tutorId;
	}
}
