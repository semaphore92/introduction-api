package com.main.introduction.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name="org_master")
public class OrgMasterVo extends BaseTimeAuditiEntity{

    @Id
    @Column(name="org_master_code")
    private String orgMasterCode;

    private String orgNameKo;
}
