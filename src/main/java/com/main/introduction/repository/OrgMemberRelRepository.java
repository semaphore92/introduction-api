package com.main.introduction.repository;

import com.main.introduction.vo.MemberVo;
import com.main.introduction.vo.OrgMemberRelVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgMemberRelRepository extends CrudRepository<OrgMemberRelVo,String> {

    @Query("select a from org_member_rel a where a.relOrgCode = :orgCode")
    public Object selectOrgInfo(String orgCode);
}