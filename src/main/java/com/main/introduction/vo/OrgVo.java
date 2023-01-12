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
public class OrgVo {

    @Id
    @Column(name="org_member_id")
    private String orgMemberId;

    private String orgCode;

    @OneToMany(mappedBy = "orgVo")
    private List<MemberVo> members = new ArrayList<>();

    @OneToOne
    @PrimaryKeyJoinColumn(name = "member_id")
    private MemberVo member;
    
}
