package com.main.introduction.repository;

import com.main.introduction.vo.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository {

    List<Person> findPerson(String name);

}