package com.example.jour3.repository;
import com.example.jour3.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByAge(int age);

    List<Person> findByName(String name);
}

