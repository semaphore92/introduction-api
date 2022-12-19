package com.main.introduction.vo;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;

@Data
@AllArgsConstructor // 모든 필드 값을 파라미터로 받은 생성자 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 생성
@Entity(name="person")
@Getter
public class Person {

    @Id
    @GeneratedValue
    private String id;

    @ManyToMany
    @JoinTable(
            name= "comment_keyword",
            joinColumns = @JoinColumn(name="comment_id"),
            inverseJoinColumns = @JoinColumn(name="keyword_id")
    )
    private Set<Person> persons = new HashSet<>();
}
