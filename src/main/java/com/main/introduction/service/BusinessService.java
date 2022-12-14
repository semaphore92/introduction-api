package com.main.introduction.service;

import com.main.introduction.repository.BusinessRepository;
import com.main.introduction.vo.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    public List<Person> findAll(){
        List<Person> personList = new ArrayList<>();
        businessRepository.findPerson("hsw").forEach(e -> personList.add(e));
        return personList;
    }
}
