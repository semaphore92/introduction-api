package com.main.introduction.controller;

import com.main.introduction.common.APIComm;
import com.main.introduction.service.MemberService;
import com.main.introduction.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class NonAuthController {

    @Autowired
    MemberService memberService;

    @Autowired
    APIComm apiComm;

    @GetMapping("/test")
    public String nonAuth(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam Map<String, Object> params){
        return "Non Auth";
    }

}
