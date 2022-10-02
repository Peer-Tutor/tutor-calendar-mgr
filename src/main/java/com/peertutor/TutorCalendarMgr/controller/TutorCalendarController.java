package com.peertutor.TutorCalendarMgr.controller;

import com.peertutor.TutorCalendarMgr.model.TutorCalendar;
import com.peertutor.TutorCalendarMgr.repository.TutorCalendarRepository;
import com.peertutor.TutorCalendarMgr.service.AuthService;
import com.peertutor.TutorCalendarMgr.service.TutorCalendarService;
import com.peertutor.TutorCalendarMgr.util.AppConfig;
import com.peertutor.TutorCalendarMgr.model.viewmodel.request.AuthenticationReq;
import com.peertutor.TutorCalendarMgr.model.viewmodel.request.TutorCalendarReq;
import com.peertutor.TutorCalendarMgr.model.viewmodel.response.TutorCalendarRes;
import com.peertutor.TutorCalendarMgr.service.dto.TutorCalendarMgrDTO;
import io.github.jhipster.web.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Map;

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

	@GetMapping(path="/public-api")
	public @ResponseBody String callPublicApi() {
		String endpoint = "https://api.publicapis.org/entries"; //url+":"+port;
		System.out.println("endpoint" + endpoint);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(endpoint, String.class);

		return response.toString();
	}

	@GetMapping(path="/call-app-tutor-mgr")
	public @ResponseBody String callAppTwo() {
		String url = appConfig.getTutorMgr().get("url");
		String port = appConfig.getTutorMgr().get("port");

		String endpoint = url+"/" ;
		System.out.println("endpoint" + endpoint);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(endpoint, String.class);

		return response.toString();
	}
	  @GetMapping(path = "/call-app-student-mgr")
	    public @ResponseBody String callAppTwo() {
	        String url = appConfig.getStudentMgr().get("url");
	        String port = appConfig.getStudentMgr().get("port");


	        String endpoint = url + "/"; //":"+port + "/";
	        System.out.println("endpoint" + endpoint);

	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<String> response = restTemplate.getForEntity(endpoint, String.class);

	        return response.toString();
	    }

	// do not remove this
	@GetMapping(path="/health")
	public @ResponseBody String healthCheck(){
		return "Ok 2";
	}

	@PostMapping(path = "/review")
	public @ResponseBody ResponseEntity<TutorCalendarRes> addNewReview(@RequestBody  @Valid TutorCalendarReq req) {

		boolean result = authService.getAuthentication(req.name, req.sessionToken);
		if (!result) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}

		TutorCalendarMgrDTO saveTutorCalendar;
		saveTutorCalendar = tutorCalendarService.addAvailableDatetime(req);

		if (saveTutorCalendar == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
		}

		TutorCalendarRes res = new TutorCalendarRes(saveTutorCalendar);

		return ResponseEntity.ok().body(res);
	}
	@PostMapping(path = "/review")
	public @ResponseBody ResponseEntity<TutorCalendarRes> updateReview(@RequestBody  @Valid TutorCalendarReq req) {

		boolean result = authService.getAuthentication(req.name, req.sessionToken);
		if (!result) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}

		TutorCalendarMgrDTO getTutorCalendar;
		getTutorCalendar = tutorCalendarService.getTutorCalendar(req.id);

		if (getTutorCalendar == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
		}

		TutorCalendarRes res = new TutorCalendarRes(getTutorCalendar);

		return ResponseEntity.ok().body(res);
	}

}
