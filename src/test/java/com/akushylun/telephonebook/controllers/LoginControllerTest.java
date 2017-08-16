package com.akushylun.telephonebook.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class LoginControllerTest {

    @Test
    public void showLoginTest() throws Exception {

	LoginController controller = new LoginController();
	MockMvc mvc = standaloneSetup(controller).build();
	mvc.perform(get("/login")).andExpect(view().name("loginForm"));

    }

}
