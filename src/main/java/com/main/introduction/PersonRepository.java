package com.main.introduction;

import com.main.introduction.vo.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(path="people")
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByLastname(String lastname);

    @RestResource(path = "byFirstname")
    List<Person> findByFirstnameLike(String firstname);

}


