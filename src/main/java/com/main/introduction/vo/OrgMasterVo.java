package com.main.introduction.vo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="org_master")
public class OrgMasterVo extends BaseTimeAuditiEntity{

    @Id
    @Column(name="org_master_code")
    private String orgMasterCode;

    @Column(name="org_name_ko")
    private String orgNameKo;

    // 1-1 단방향 연관 매핑
    /*
    @OneToOne
    @JoinColumn(name="org_member_id")
    private MemberVo orgMemberId;
*/
}
