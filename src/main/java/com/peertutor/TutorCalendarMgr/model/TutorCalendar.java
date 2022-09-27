package com.peertutor.TutorCalendarMgr.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "tutorcalendar")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TutorCalendar {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "tutor_id", nullable = false, unique = true)
	private Long tutorID;
	
	@Column(name = "availableDate", nullable = false, unique = true)
	private Date  availableDate;
	

	@Column(name = "startTime", nullable = false, unique = true)
	private Timestamp startTime;
	
	@Column(name = "endTime", nullable = false, unique = true)
	private Timestamp endTime;


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
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getTutorID() {
		return tutorID;
	}

	public void setTutorID(Long tutorID) {
		this.tutorID = tutorID;
	}

	

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TutorCalendar tutorCalendar = (TutorCalendar) o;
        if (tutorCalendar.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tutorCalendar.getId()) &&
                Objects.equals(getAvailableDate(), tutorCalendar.getAvailableDate()) &&
                Objects.equals(getStartTime(), tutorCalendar.getStartTime()) &&
                Objects.equals(getEndTime(), tutorCalendar.getEndTime());
    }
}
