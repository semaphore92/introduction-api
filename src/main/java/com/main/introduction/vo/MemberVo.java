package com.main.introduction.vo;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;

@Data
@AllArgsConstructor // 모든 필드 값을 파라미터로 받은 생성자 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 생성
@Entity(name="member")
public class MemberVo {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long mbrNo;

    private String id;

    private String name;

    @Builder
    public MemberVo(String id, String name){
        this.id = id;
        this.name = name;
    }
}
