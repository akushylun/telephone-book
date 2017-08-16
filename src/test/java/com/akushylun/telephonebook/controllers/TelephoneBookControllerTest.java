package com.akushylun.telephonebook.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class TelephoneBookControllerTest {

    TelephoneBookController controller = new TelephoneBookController();
    MockMvc mvc = standaloneSetup(controller).build();

    @Test
    public void showRecordFormTest() throws Exception {
	mvc.perform(get("/getRecordForm")).andExpect(view().name("recordForm")).andExpect(model().size(1))
		.andExpect(model().attributeExists("record"));
    }

}
