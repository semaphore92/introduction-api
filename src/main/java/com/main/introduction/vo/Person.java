package com.main.introduction.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor // 모든 필드 값을 파라미터로 받은 생성자 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 생성
@Entity(name="person")
public class Person {
    @Id
    private String id;
}
