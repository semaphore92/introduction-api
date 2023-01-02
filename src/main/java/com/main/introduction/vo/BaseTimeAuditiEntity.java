package com.main.introduction.vo;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 해당 추상 클래스를 상속할 경우 아래 변수들을 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)  // 해당 클래스에 Auditing 기능을 포함
public abstract class BaseTimeAuditiEntity {

    @CreatedDate // Entity가 생성되어 저장될 때 시간이 자동 저장
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedData;
}
