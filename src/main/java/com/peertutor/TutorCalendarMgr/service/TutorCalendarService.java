package com.peertutor.TutorCalendarMgr.service;

import com.peertutor.TutorCalendarMgr.model.TutorCalendar;
import com.peertutor.TutorCalendarMgr.model.viewmodel.request.TutorCalendarReq;
import com.peertutor.TutorCalendarMgr.model.viewmodel.response.TutorCalendarRes;
import com.peertutor.TutorCalendarMgr.repository.TutorCalendarRepository;
import com.peertutor.TutorCalendarMgr.service.dto.TutorCalendarMgrDTO;
import com.peertutor.TutorCalendarMgr.service.mapper.TutorCalendarMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TutorCalendarService{
	
	private static final Logger logger = LoggerFactory.getLogger(TutorCalendarService.class);
    private final TutorCalendarMapper tutorCalendarMapper;
    private TutorCalendarRepository tutorCalendarRepository;
    
    public TutorCalendarService(TutorCalendarRepository tutorCalendarRepository, TutorCalendarMapper tutorCalendarMapper) {
        this.tutorCalendarRepository = tutorCalendarRepository;
        this.tutorCalendarMapper = tutorCalendarMapper;
    }

    public List<TutorCalendar> addAvailableDate(TutorCalendarReq req) {
        tutorCalendarRepository.deleteAllByTutorId(req.tutorId);

        req.availableDates.stream().forEach(date -> {
            TutorCalendar tutorCalendar = new TutorCalendar();
            tutorCalendar.setTutorId(req.tutorId);
            tutorCalendar.setAvailableDate(date);

            try {
                tutorCalendar = tutorCalendarRepository.save(tutorCalendar);
            } catch (Exception e) {
                logger.error("Add available time slot fail: " + e.getMessage());
            }
        });

        return tutorCalendarRepository.findAllByTutorId(req.tutorId);
    }

    public TutorCalendarRes getTutorCalendar(Long tutorID) {
    	List<TutorCalendar> tutorCalendar = tutorCalendarRepository.findAllByTutorId(tutorID);

        List<Date> dates = tutorCalendar.stream().map(c -> c.getAvailableDate()).collect(Collectors.toList());
        Collections.sort(dates);
        return new TutorCalendarRes(dates);
    }
}
