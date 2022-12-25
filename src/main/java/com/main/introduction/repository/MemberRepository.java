package com.main.introduction.repository;

import com.main.introduction.vo.MemberVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberVo,String> {
    public Optional<MemberVo> findById(String memberId);
}