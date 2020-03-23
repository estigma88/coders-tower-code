package com.coderstower.blog.websecurityauthenticationauthorization;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebSecurityAuthenticationAuthorizationApplicationTests {
	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
	}

	@Test
	@WithMockUser(username = "ex-boyfriend", roles = { "EXBOYFRIEND" })
	public void loveYou_unknownUser_reject() throws Exception {
		mvc.perform(get("/love-you")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isForbidden());
	}


	@Test
	@WithMockUser(username = "john", roles = { "BOYFRIEND" })
	public void loveYou_userJohn_accept() throws Exception {
		mvc.perform(get("/love-you")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("Love you too"));
	}

	@Test
	@WithMockUser(username = "john", roles = { "BOYFRIEND" })
	public void canMeetYourParents_userJohn_cannot() throws Exception {
		mvc.perform(get("/can-meet-your-parents")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isForbidden());
	}

	@Test
	@WithMockUser(username = "john", roles = { "BOYFRIEND", "CAN_MEET_PARENTS" })
	public void canMeetYourParents_userJohnWithRoleCAN_MEET_PARENTS_cannot() throws Exception {
		mvc.perform(get("/can-meet-your-parents")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("You can"));
	}

}
