package com.akushylun.telephonebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akushylun.telephonebook.entities.Person;
import com.akushylun.telephonebook.entities.Record;
import com.akushylun.telephonebook.repository.PersonRepository;
import com.akushylun.telephonebook.repository.RecordRepository;

@Controller
public class TelephoneBookController {

    private RecordRepository recordRepository;
    private PersonRepository personRepository;

    @Autowired
    @Qualifier("RecordRepositoryHibernate")
    public void setRecordRepository(RecordRepository recordRepository) {
	this.recordRepository = recordRepository;
    }

    @Autowired
    @Qualifier("PersonRepositoryHibernate")
    public void setPersonRepository(PersonRepository personRepository) {
	this.personRepository = personRepository;
    }

    @RequestMapping(value = "/telephoneBook", method = RequestMethod.GET)
    public String showTelephoneRecords(Model model) {
	List<Record> recordsList = recordRepository.findByPersonId(getAuthenticationUser().getId());
	model.addAttribute("records", recordsList);
	return "telRecords";
    }

    private Person getAuthenticationUser() {
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	Person person = personRepository.findByUsername(userDetails.getUsername());
	return person;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getRecordForm")
    public String showRecordForm(Model model) {
	model.addAttribute(new Record());
	return "recordForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getRecordForm")
    public String createRecord(@Valid Record record, Errors errors) {
	if (errors.hasErrors()) {
	    return "recordForm";
	}
	record.setUser(getAuthenticationUser());
	recordRepository.save(record);
	return "redirect:/telephoneBook";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteForm")
    public String deleteRecord(Record record) {
	recordRepository.delete(record.getId());
	return "redirect:/telephoneBook";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/updateForm")
    public String updateRecord(Model model, Record record) {
	model.addAttribute("record", record);
	return "updateForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateForm")
    public String updateRecord(@Valid Record record, Errors errors) {
	if (errors.hasErrors()) {
	    return "updateForm";
	}
	record.setUser(getAuthenticationUser());
	recordRepository.save(record);
	return "redirect:/telephoneBook";
    }

}
