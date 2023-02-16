package com.main.introduction.controller;

import com.main.introduction.common.APIComm;
import com.main.introduction.service.DiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/discovery/test")
public class DiscoveryController {

    @Autowired
    APIComm apiComm;

    @Autowired
    DiscoveryService discoveryService;

    @GetMapping("/info")
    public Map<String, Object> info(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam Map<String, Object> params){

        return apiComm.getResponseData(response, HttpStatus.OK.toString(), discoveryService.getInfo(),null);
    }

}
