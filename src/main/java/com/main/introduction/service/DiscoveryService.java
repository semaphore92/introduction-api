package com.main.introduction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class DiscoveryService {

    @Autowired
    RestTemplate restTemplate;
    public String getInfo(){



        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity request = new HttpEntity(headers);


        Map<String,Object> newMap = new HashMap<>();

        ResponseEntity<Object> restExchange =
                restTemplate.exchange("http://MEMBERSERVICE/api/member/test", HttpMethod.GET,request,Object.class,newMap);

        return "test";
    }

}
