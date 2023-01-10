package com.main.introduction.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name="org_member_rel")
public class OrgRelVo extends BaseTimeAuditiEntity{

    @Id
    @Column(name="org_code")
    private String orgCode;

    private String orgNameKo;
}
