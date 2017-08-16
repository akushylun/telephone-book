package com.akushylun.telephonebook.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akushylun.telephonebook.entities.Person;
import com.akushylun.telephonebook.repository.PersonRepository;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    private PersonRepository repository;

    @Autowired
    @Qualifier("PersonRepositoryHibernate")
    public void setRepository(PersonRepository repository) {
	this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
	model.addAttribute(new Person());
	return "registrationForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistrationForm(@Valid Person person, Errors errors) {
	if (errors.hasErrors()) {
	    return "registrationForm";
	}
	repository.save(person);
	return "redirect:/login";
    }

}
