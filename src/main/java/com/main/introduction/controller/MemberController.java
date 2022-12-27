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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    APIComm apiComm;

    @GetMapping("/info")
    public Map<String, Object> info(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam Map<String, Object> params){

        String memberId = params.get("member_id").toString();
        Optional<MemberVo> memberInfo = memberService.selectMemberId(memberId);

        return apiComm.getResponseData(response, HttpStatus.OK.toString(),memberInfo,null);
    }


    @GetMapping("/join")
    public Map<String, Object> join(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam Map<String, Object> params){

        memberService.oneToOne();
        return apiComm.getResponseData(response, HttpStatus.OK.toString(),new HashMap<>(),null);
    }

}
