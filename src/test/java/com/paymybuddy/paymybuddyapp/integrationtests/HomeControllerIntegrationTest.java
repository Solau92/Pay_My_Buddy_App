package com.paymybuddy.paymybuddyapp.integrationtests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.nio.file.Path;

import static jdk.internal.jimage.ImageReaderFactory.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getHomeTest() throws IOException {
/*		mockMvc.perform(get("/user/home"))
				.andExpect(status().isAccepted())
				.andExpect();*/

	}

}