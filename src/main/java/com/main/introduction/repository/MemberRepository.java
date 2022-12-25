package com.main.introduction.repository;

import com.main.introduction.vo.MemberVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository {
    public List<MemberVo> findByMemberId(String memberId);
}