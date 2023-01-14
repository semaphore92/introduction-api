package com.main.introduction.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity(name="org_member_rel")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 생성
public class OrgMemberRelVo extends BaseTimeAuditiEntity{

    @Id
    @Column(name="rel_member_id")
    private String relMemberId;

    @Column(name="rel_org_code", nullable = false)
    private String relOrgCode;

    @OneToMany(mappedBy = "orgMemberRelVo")
    private List<MemberVo> members = new ArrayList<>();

    @OneToOne
    @PrimaryKeyJoinColumn(name = "member_id")
    private MemberVo member;

}
