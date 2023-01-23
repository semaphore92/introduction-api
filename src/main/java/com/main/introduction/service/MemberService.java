package com.main.introduction.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.main.introduction.repository.MemberRepository;
import com.main.introduction.repository.OrgMasterRepository;
import com.main.introduction.spec.MemberSpecs;
import com.main.introduction.vo.MemberVo;
import com.main.introduction.vo.OrgMasterVo;
import com.main.introduction.vo.OrgMemberRelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private OrgMasterRepository orgMasterRepository;


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
        return  memberRepository.save(memberVo);
    }

    public List<Map<String,Object>> retrieveMemberList(){

        List<MemberVo> memberVoList = memberRepository.selectMemberList();

        // List<Object> -> Map<String,MemberVo>로 변경
        /*
        Map<String,MemberVo> data = memberVoList.stream()
                .filter(member -> member.getMemberId().equals("swheo"))
                .collect(Collectors.toMap(MemberVo::getMemberId ,memberVo -> memberVo));
        */

        //https://codingexplore.tistory.com/84
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());


        List<Map<String,Object>> dataList = new ArrayList<>();
        for(MemberVo memberVo: memberVoList){

            Map<String,Object> dataMap = objectMapper.convertValue(memberVo,Map.class);
            dataMap.put("test","aa");

            dataList.add(dataMap);
        }

        return dataList;
    }

    public void likeMemberId(String memberId){
        Specification<MemberVo> nameSpec = MemberSpecs.nameLike(memberId);
    }
}
