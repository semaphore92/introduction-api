package com.main.introduction.repository;

import com.main.introduction.vo.MemberVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<MemberVo,String> {

    @Query("select a from member_master a where a.memberId = :memberId")
    public Object selectSingleInfo(@Param("memberId") String memberId);

    @Query("select a from member_master a")
    public List<MemberVo> selectMemberList();

    /*
    @Query("select a from member_master a join fetch a.orgMemberRelVo")
    public Object getJoin();
     */

    @Query(value="select * from member_master", nativeQuery = true)
    public List<MemberVo> nativeQuerySelect();
}