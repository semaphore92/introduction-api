package com.main.introduction.service;

import com.main.introduction.repository.BusinessRepository;
import com.main.introduction.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    public List<MemberVo> findAll(){
        List<MemberVo> personList = new ArrayList<>();
        businessRepository.findById("hsw").forEach(e -> personList.add(e));
        return personList;
    }
}
