package com.main.introduction.controller;

import com.main.introduction.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/info")
    public String info(HttpServletRequest request, HttpServletResponse response,
                       @RequestParam Map<String, Object> params){

        String memberId = params.get("memberId").toString();
        memberService.selectMemberId(memberId);

        return null;
    }

}
