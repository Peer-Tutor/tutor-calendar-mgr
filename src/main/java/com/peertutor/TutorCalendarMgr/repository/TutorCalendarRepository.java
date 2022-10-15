package com.peertutor.TutorCalendarMgr.repository;

import com.peertutor.TutorCalendarMgr.model.TutorCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TutorCalendarRepository extends JpaRepository<TutorCalendar, Long> {
    TutorCalendar findByTutorId(long id);
    List<TutorCalendar> findAllByTutorId(long id);
    List<TutorCalendar> findAllByTutorIdAndAvailableDateIn(long id, List<Date> availableDate);
    void deleteAllByTutorIdAndAvailableDateIn(long id, List<Date> availableDate);
    TutorCalendar findByTutorIdAndAvailableDate(long id, Date availableDate);
    Integer deleteAllByTutorId(long id);
}

