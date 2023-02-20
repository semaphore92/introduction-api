package com.main.introduction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Map;

@Service
public class DiscoveryService {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    DiscoveryClient discoveryClient;

    public Map<String,Object> getInfo(){

        List<String> serviceList = discoveryClient.getServices();

        // Eureka에 등록된 서비스 이름
        ServiceInstance instance = loadBalancerClient.choose("memberService");

        // 선택된 인스턴스의 주소를 가져와서 RestTemplate로 호출
        String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort();
        Map<String,Object> resultMap = new RestTemplate().getForObject(baseUrl + "/api/member/info", Map.class);


        return resultMap;
    }

}
