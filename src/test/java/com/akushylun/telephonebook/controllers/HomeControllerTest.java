package com.akushylun.telephonebook.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class HomeControllerTest {

    @Test
    public void homeTest() throws Exception {

	HomeController controller = new HomeController();
	MockMvc mvc = standaloneSetup(controller).build();
	mvc.perform(get("/")).andExpect(view().name("index"));

    }

}
