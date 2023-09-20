package com.example.jour3.controller;

import com.example.jour3.model.Person;
import com.example.jour3.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String listPersons(Model model) {
        Iterable<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "person/list";
    }

    @GetMapping("/add")
    public String addPersonForm(@RequestParam String name, @RequestParam int age, Model model) {
        Person person = new Person(name, age);
        model.addAttribute("person", person);
        return "person/add";
    }

    @PostMapping("/add")
    public String savePerson(@ModelAttribute Person person) {
        personRepository.save(person);
        return "redirect:/persons/";
    }

    @GetMapping("/edit/{id}")
    public String editPersonForm(@PathVariable Long id, Model model) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person ID"));
        model.addAttribute("person", person);
        return "person/edit";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable Long id, @ModelAttribute Person updatedPerson) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person ID"));

        person.setName(updatedPerson.getName());
        person.setAge(updatedPerson.getAge());

        personRepository.save(person);

        return "redirect:/persons/";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return "redirect:/persons/";
    }
}

