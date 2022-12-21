package com.main.introduction.repository;

import com.main.introduction.vo.MemberVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository {

    public List<MemberVo> findById(String id);

    public List<MemberVo> findByName(String name);

    public List<MemberVo> findByNameLike(String keyword);

}