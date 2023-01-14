package com.main.introduction.service;

import com.main.introduction.repository.MemberRepository;
import com.main.introduction.spec.MemberSpecs;
import com.main.introduction.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.lang.reflect.Member;
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
    public Object selectMemberId(String memberId){

        Object memberInfo = Optional.ofNullable(new MemberVo("non","non"));
        memberInfo = memberRepository.selectSingleInfo(memberId);
        return memberInfo;
    }

    /**
     *  회원 정보를 Save 한다.
     *
     * @param memberVo Insert Member 정보
     * @return  Insert 성공 여부
     */
    public Object saveMember(MemberVo memberVo){
        return memberRepository.save(memberVo);
    }

    public void join(){
        Object result = memberRepository.getJoin();
        System.out.println(result.toString());
    }

    public void likeMemberId(String memberId){

        Specification<MemberVo> nameSpec = MemberSpecs.nameLike(memberId);

    }
}
