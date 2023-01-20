package com.main.introduction.service;

import com.main.introduction.repository.MemberRepository;
import com.main.introduction.repository.OrgMasterRepository;
import com.main.introduction.repository.OrgMemberRelRepository;
import com.main.introduction.spec.MemberSpecs;
import com.main.introduction.vo.MemberVo;
import com.main.introduction.vo.OrgMasterVo;
import com.main.introduction.vo.OrgMemberRelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.lang.reflect.Member;
import java.util.*;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    OrgMemberRelRepository orgMemberRelRepository;

    @Autowired
    OrgMasterRepository orgMasterRepository;


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
        String orgMasterCode = params.get("org_master_code").toString();

        OrgMasterVo orgMasterVo = orgMasterRepository.selectOrgMasterCode(orgMasterCode);
        String orgCode = orgMasterVo.getOrgMasterCode();

        List<OrgMemberRelVo> orgMemberRelVoList = new ArrayList<>();
        orgMemberRelVoList.add(new OrgMemberRelVo(memberId,orgCode));

        //MemberVo memberVo = new MemberVo(memberId,nameKo,orgMemberRelVoList);
        MemberVo memberVo = new MemberVo(memberId,nameKo);
        return  memberRepository.save(memberVo);
    }

    public void likeMemberId(String memberId){
        Specification<MemberVo> nameSpec = MemberSpecs.nameLike(memberId);
    }
}
