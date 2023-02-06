package com.main.introduction.controller;

import com.main.introduction.common.APIComm;
import com.main.introduction.service.MemberService;
import com.main.introduction.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/temp")
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    APIComm apiComm;

    @PostMapping("/save")
    public Map<String, Object> save(HttpServletRequest request, HttpServletResponse response,
                                    @RequestBody Map<String, Object> params){
        return apiComm.getResponseData(response, HttpStatus.OK.toString(), memberService.saveMember(params),null);
    }

    @GetMapping("/info")
    public Map<String, Object> info(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam Map<String, Object> params){
        return apiComm.getResponseData(response, HttpStatus.OK.toString(), memberService.retrieveMemberList(),null);
    }


}
