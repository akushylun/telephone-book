package com.akushylun.telephonebook.controllers;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.akushylun.telephonebook.entities.Person;
import com.akushylun.telephonebook.repository.PersonRepository;

public class RegistrationControllerTest {

    PersonRepository repository = mock(PersonRepository.class);
    RegistrationController controller = new RegistrationController();

    @Test
    public void showRegistrationFormTest() throws Exception {
	MockMvc mvc = standaloneSetup(controller).build();
	mvc.perform(get("/registration")).andExpect(view().name("registrationForm")).andExpect(model().size(1))
		.andExpect(model().attributeExists("person"));
    }

    @Test
    public void processSuccesRegistrationFormTest() throws Exception {
	controller.setRepository(repository);
	Person person = new Person(1, "Johnson", "johnnson", "12345");
	MockMvc mvc = standaloneSetup(controller).build();
	mvc.perform(post("/registration").contentType(MediaType.APPLICATION_FORM_URLENCODED)
		.param("fullName", person.getFullName()).param("password", person.getPassword())
		.param("username", person.getUsername())).andDo(print()).andExpect(redirectedUrl("/login"));

    }

    @Test
    public void processFailRegistrationFormTest() throws Exception {
	MockMvc mvc = standaloneSetup(controller).build();
	mvc.perform(post("/registration")).andExpect(view().name("registrationForm"));

    }

}
