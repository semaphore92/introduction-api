package com.main.introduction.spec;

import com.main.introduction.vo.MemberVo;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MemberSpecs {
    public static Specification<MemberVo> nameLike(String value){
        return (root,query,cb) -> cb.like(root.get("name"), "%" + value + "%");
    }
}
