package com.main.introduction.repository;

import com.main.introduction.vo.MemberVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<MemberVo,String> {
    @Query("select a from member_master a where a.memberId = :memberId")
    public Object selectSingleInfo(@Param("memberId") String memberId);

    @Query("select a from member_master a join fetch a.orgVo")
    public Object getJoin();

    @Query(value="select * from member_master", nativeQuery = true)
    public List<MemberVo> nativeQuerySelect();
}