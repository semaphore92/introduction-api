package com.main.introduction.vo;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
//@AllArgsConstructor // 모든 필드 값을 파라미터로 받은 생성자 생성
//@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 생성
@Entity(name = "member_master")
public class MemberVo extends BaseTimeAuditiEntity {

    @Id
    @Column(name="member_id", nullable = false)
    private String memberId;

    @Column(name="name_ko", nullable = false)
    private String nameKo;

    @OneToMany(mappedBy = "memberVo")
    private List<OrgMemberRelVo> orgMemberRelList = new ArrayList<>();

    @Builder
    public MemberVo(String memberId,String nameKo){
        this.memberId = memberId;
        this.nameKo = nameKo;
    }

    @Builder
    public MemberVo(String memberId,String nameKo, List<OrgMemberRelVo> orgMemberRelList ){
        this.memberId = memberId;
        this.nameKo = nameKo;
        this.orgMemberRelList = orgMemberRelList;
    }

    public MemberVo() {

    }
}
