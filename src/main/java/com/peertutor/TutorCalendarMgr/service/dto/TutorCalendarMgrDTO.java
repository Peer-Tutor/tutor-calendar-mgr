package com.peertutor.TutorCalendarMgr.service.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * A DTO for the {@link com.peertutor.TutorCalendarmgr.model.TutorCalendar} entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TutorCalendarMgrDTO implements Serializable{

	private Long id;
	private Long tutorID;
	private Date  availableDate;
	private Timestamp startTime;
	private Timestamp endTime;
	
	public Long getId() {
		return id;
	}
	public Long getTutorID() {
		return tutorID;
	}
	public void setTutorID(Long tutorID) {
		this.tutorID = tutorID;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getAvailableDate() {
		return availableDate;
	}
	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}
	public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.startTime = endTime;
    }
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TutorCalendarMgrDTO tutorCalendarMgrDTO = (TutorCalendarMgrDTO) o;
        if (tutorCalendarMgrDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tutorCalendarMgrDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    @Override
    public String toString() {
        return "TutorCalendarMgrDTO{" +
                "id=" + getId() +
                ", Date=" + getAvailableDate() +
                ", start time=" + getStartTime()+
                ", end time="+ getEndTime()+ "'" +
                "}";
    }
	
}
