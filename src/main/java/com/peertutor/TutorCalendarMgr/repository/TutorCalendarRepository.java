package com.peertutor.TutorCalendarMgr.repository;

import com.peertutor.TutorCalendarMgr.model.TutorCalendar;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorCalendarRepository extends JpaRepository<TutorCalendar, Long> {
    List<TutorCalendar> findByLastName(String lastName);
    TutorCalendar findById(long id);
}

