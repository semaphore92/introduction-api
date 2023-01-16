package com.main.introduction.repository;

import com.main.introduction.vo.MemberVo;
import com.main.introduction.vo.OrgMasterVo;
import com.main.introduction.vo.OrgMemberRelVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgMasterRepository extends CrudRepository<OrgMemberRelVo,String> {
    @Query(value="select a from org_master a where a.orgMasterCode = :orgMasterCode")
    public OrgMasterVo selectOrgMasterCode(@Param("orgMasterCode") String orgMasterCode);

}