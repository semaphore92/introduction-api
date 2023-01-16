package com.main.introduction.service;

import com.main.introduction.repository.MemberRepository;
import com.main.introduction.repository.OrgMemberRelRepository;
import com.main.introduction.spec.MemberSpecs;
import com.main.introduction.vo.MemberVo;
import com.main.introduction.vo.OrgMemberRelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    OrgMemberRelRepository orgMemberRelRepository;


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
     * @param params Insert Member 정보
     * @return  Insert 성공 여부
     */
    public Object saveMember(Map<String,Object> params){

        String memberId = params.get("member_id").toString();
        String nameKo = params.get("name_ko").toString();
        MemberVo memberVo = new MemberVo(memberId,nameKo);
        memberRepository.save(memberVo);

        OrgMemberRelVo orgMemberRelVo = new OrgMemberRelVo(memberId,"AAAA");
        orgMemberRelRepository.save(orgMemberRelVo);

        return null;
    }

    public void likeMemberId(String memberId){

        Specification<MemberVo> nameSpec = MemberSpecs.nameLike(memberId);

    }
}
