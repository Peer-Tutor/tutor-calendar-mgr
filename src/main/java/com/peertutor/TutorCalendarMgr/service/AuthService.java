package com.peertutor.TutorCalendarMgr.service;

import com.peertutor.TutorCalendarMgr.util.AppConfig;
import com.peertutor.TutorCalendarMgr.model.viewmodel.request.AuthenticationReq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    @Autowired
    AppConfig appConfig;

    public boolean getAuthentication(String name, String sessionToken) {
        String url = appConfig.getAccountMgr().get("url");
        String port = appConfig.getAccountMgr().get("port");

        String endpoint = url + "/auth";
        System.out.println("endpoint" + endpoint);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        AuthenticationReq req = new AuthenticationReq(name, sessionToken);

        HttpEntity<AuthenticationReq> request = new HttpEntity<AuthenticationReq>(req, headers);

        Boolean result = restTemplate.postForObject(endpoint, request, Boolean.class);
        return result;
    }
}