package com.main.introduction.common;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class APIComm {

    public Map<String,Object> getResponseData(HttpServletResponse response, String code, Object result, Object[] args){

        Map<String,Object> respData = new HashMap<>();
        respData.put("code",code);
        respData.put("data",result);

        return respData;
    }
}
