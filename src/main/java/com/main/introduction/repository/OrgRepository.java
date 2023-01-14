package com.main.introduction.repository;

import com.main.introduction.vo.MemberVo;
import com.main.introduction.vo.OrgMemberRelVo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrgRepository extends CrudRepository<OrgMemberRelVo,String> {

}