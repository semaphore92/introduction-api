package com.main.introduction.vo;

import lombok.*;

import javax.persistence.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@Data
//@AllArgsConstructor // 모든 필드 값을 파라미터로 받은 생성자 생성
//@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 생성
@Entity(name="member_master")
public class MemberVo {

    @EmbeddedId
    private String memberId;

    private String nameKo;

    @ManyToOne(fetch = FetchType.LAZY) //지연 로딩
    @JoinColumn(name = "member_id")
    private OrgVo orgVo;


    @Builder
    public MemberVo(String memberId,String nameKo){
        this.memberId = memberId;
        this.nameKo = nameKo;
    }

    public MemberVo() {

    }
}
