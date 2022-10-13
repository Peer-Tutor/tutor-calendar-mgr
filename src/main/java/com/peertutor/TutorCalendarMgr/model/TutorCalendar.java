package com.peertutor.TutorCalendarMgr.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "tutor_calendar")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TutorCalendar {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "tutor_id", nullable = false, unique = true)
	private Long tutorId;
	
	@Column(name = "available_date", nullable = false, unique = true)
	private Date availableDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTutorId() {
		return tutorId;
	}

	public void setTutorId(Long tutorID) {
		this.tutorId = tutorID;
	}

	public Date getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TutorCalendar)) return false;
		TutorCalendar that = (TutorCalendar) o;
		return getId().equals(that.getId()) && getTutorId().equals(that.getTutorId()) && getAvailableDate().equals(that.getAvailableDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getTutorId(), getAvailableDate());
	}
}
