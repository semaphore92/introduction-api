package com.main.introduction.service;

import com.main.introduction.repository.MemberRepository;
import com.main.introduction.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<MemberVo> selectMemberId(String memberId){

        List<MemberVo> personList = new ArrayList<>();
        memberRepository.findById(memberId).forEach(e -> personList.add(e));
        return personList;
    }
}
