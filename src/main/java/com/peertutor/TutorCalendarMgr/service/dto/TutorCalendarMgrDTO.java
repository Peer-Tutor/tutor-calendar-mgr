package com.peertutor.TutorCalendarMgr.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TutorCalendarMgrDTO implements Serializable{

	private Long id;
	private Long tutorId;
	private Date availableDate;
	
	public Long getId() {
		return id;
	}
	public Long getTutorId() {
		return tutorId;
	}
	public void setTutorId(Long tutorId) {
		this.tutorId = tutorId;
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
                "id=" + id +
                ", tutorID=" + tutorId +
                ", availableDate=" + availableDate +
                '}';
    }
}
