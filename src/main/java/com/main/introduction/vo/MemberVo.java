package com.main.introduction.vo;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false) //지연 로딩
    @JoinColumn(name = "member_id",insertable = false,updatable = false)
    private OrgMemberRelVo orgMemberRelVo;

    @Builder
    public MemberVo(String memberId,String nameKo){
        this.memberId = memberId;
        this.nameKo = nameKo;
    }

    public MemberVo() {

    }
}
