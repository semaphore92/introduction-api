package com.main.introduction.service;

import com.main.introduction.repository.MemberRepository;
import com.main.introduction.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Optional<MemberVo> selectMemberId(String memberId){

        Optional<MemberVo> memberInfo = Optional.ofNullable(new MemberVo("non","non"));
        memberInfo = memberRepository.findById(memberId);
        return memberInfo;
    }
}
