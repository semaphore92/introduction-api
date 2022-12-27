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

@Data
@AllArgsConstructor // 모든 필드 값을 파라미터로 받은 생성자 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 생성
@Entity(name="org_member_rel")
public class OrgVo {

    @EmbeddedId
    private String memberId;

    private String orgCode;

    @OneToMany(mappedBy = "org_member_rel")
    private List<MemberVo> members = new ArrayList<>();
}
