package com.main.introduction.vo;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude = "orgMemberRelList")
//@AllArgsConstructor // 모든 필드 값을 파라미터로 받은 생성자 생성
//@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 생성
@Entity(name = "member_master")
public class MemberVo extends BaseTimeAuditiEntity {

    @Id
    @Column(name="member_id", nullable = false)
    private String memberId;

    @Column(name="member_name_ko", nullable = false)
    private String memberNameKo;

    // 단방향 OneToMany 조인
    /*@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="rel_member_id")
    private List<OrgMemberRelVo> orgMemberRelList;
*/
    @Builder
    public MemberVo(String memberId,String nameKo){
        this.memberId = memberId;
        this.memberNameKo = nameKo;
    }

    public MemberVo() {

    }
}
