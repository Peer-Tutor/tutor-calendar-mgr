package com.peertutor.TutorCalendarMgr.controller;

import com.peertutor.TutorCalendarMgr.model.TutorCalendar;
import com.peertutor.TutorCalendarMgr.model.viewmodel.request.TutorCalendarReq;
import com.peertutor.TutorCalendarMgr.model.viewmodel.response.TutorCalendarRes;
import com.peertutor.TutorCalendarMgr.repository.TutorCalendarRepository;
import com.peertutor.TutorCalendarMgr.service.AuthService;
import com.peertutor.TutorCalendarMgr.service.TutorCalendarService;
import com.peertutor.TutorCalendarMgr.service.dto.TutorCalendarMgrDTO;
import com.peertutor.TutorCalendarMgr.util.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path="/tutor-calendar-mgr")
public class TutorCalendarController {

	@Autowired
	AppConfig appConfig;
	@Autowired
	private TutorCalendarRepository tutorCalendarRepository;// = new CustomerRepository();
	@Autowired
	private TutorCalendarService tutorCalendarService;
	@Autowired
	private AuthService authService;

	// do not remove this
	@GetMapping(path="/health")
	public @ResponseBody String healthCheck(){
		return "Ok 2";
	}

	@PostMapping(path = "/calendar")
	@Transactional
	public @ResponseBody ResponseEntity<List<TutorCalendar>> addAvailableDate(@RequestBody  @Valid TutorCalendarReq req) {
/*
		boolean result = authService.getAuthentication(req.name, req.sessionToken);
		if (!result) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}*/
		if (req.availableDates == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}

		List<TutorCalendar> saveTutorCalendar;
		saveTutorCalendar = tutorCalendarService.addAvailableDate(req);

		if (saveTutorCalendar == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
		}
		return ResponseEntity.ok().body(saveTutorCalendar);
	}

	@GetMapping(path = "/calendar")
	public @ResponseBody ResponseEntity<TutorCalendarRes> getReview(@RequestParam(name = "tutorId") Long tutorId) {
/*
		boolean result = authService.getAuthentication(req.name, req.sessionToken);
		if (!result) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}*/

		TutorCalendarRes tutorCalendar = tutorCalendarService.getTutorCalendar(tutorId);
		return ResponseEntity.ok().body(tutorCalendar);
	}
}
