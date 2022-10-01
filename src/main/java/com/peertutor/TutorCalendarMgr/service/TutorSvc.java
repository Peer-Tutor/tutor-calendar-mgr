package com.peertutor.TutorCalendarMgr.service;
import com.peertutor.TutorCalendarMgr.model.viewmodel.request.TutorReq;
import com.peertutor.TutorCalendarMgr.util.AppConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class TutorSvc {
	 @Autowired
	 AppConfig appConfig;
	 
	 public Long getTutorId() {
		 String url = appConfig.getTuitionOrderMgr().get("url");
	        String port = appConfig.getTuitionOrderMgr().get("port");

	        String endpoint = url + "/tutor";
	        System.out.println("endpoint" + endpoint);

	        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
	        headers.add("Content-Type", "application/json");

	        RestTemplate restTemplate = new RestTemplate();
	        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	        TutorReq req = new TutorReq();
	        Long tutorTutorId = req.getTutorId();

	        HttpEntity<AuthenticationReq> request = new HttpEntity<AuthenticationReq>(req, headers);

	        tutorTutorId = restTemplate.postForObject(endpoint, request, Long.class);
	        return tutorTutorId;
	 }
}
