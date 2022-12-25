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

    /**
     *  회원의 ID로 회원의 정보를 반환한다.
     *
     * @param memberId 반환할 회원 정보의 ID
     * @return 회원 ID로 조회한 회원 정보
     * @throws NullPointerException memberId가 null이면, 발생한다.
     */
    public Optional<MemberVo> selectMemberId(String memberId){

        Optional<MemberVo> memberInfo = Optional.ofNullable(new MemberVo("non","non"));
        memberInfo = memberRepository.findById(memberId);
        return memberInfo;
    }
}
