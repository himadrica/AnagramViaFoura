package com.via.foura.app;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AnagramControllerTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void test_anagram_with_invalid_strings() throws Exception {

		mvc.perform(get("/anagrams/ice**man/iceman").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.statusCode", is(400)))
				.andExpect(jsonPath("$.message", is("400 - Bad Request")))
				.andExpect(jsonPath("$.details", hasItems("Invalid input strings to check anagrams")));
	}

	@Test
	public void test_anagram_with_invalid_empty_strings() throws Exception {

		mvc.perform(get(new URI("/anagrams/iceman/%20").getPath()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.statusCode", is(400)))
				.andExpect(jsonPath("$.message", is("400 - Bad Request")))
				.andExpect(jsonPath("$.details", hasItems("Invalid input strings to check anagrams")));

		mvc.perform(get(new URI("/anagrams/%20%20/abc").getPath()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.statusCode", is(400)))
				.andExpect(jsonPath("$.message", is("400 - Bad Request")))
				.andExpect(jsonPath("$.details", hasItems("Invalid input strings to check anagrams")));
	}

	@Test
	public void test_anagram_with_valid_anagram_strings() throws Exception {

		mvc.perform(get("/anagrams/iceman/cinema").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.areAnagrams", is(true)));
	}

	@Test
	public void test_anagram_with_valid_strings_notaganaram() throws Exception {
		mvc.perform(get("/anagrams/iceman/cinama").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.areAnagrams", is(false)));
	}

	@Test
	public void test_anagram_with_valid_different_length() throws Exception {

		mvc.perform(get("/anagrams/iceman/nema").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.areAnagrams", is(false)));
	}

	@Test
	public void test_generated_anagrams_with_invalid_strings() throws Exception {

		mvc.perform(get("/anagrams/ice**man").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.message", is("400 - Bad Request")))
				.andExpect(jsonPath("$.details", hasItems("Not a valid input string to generate anagrams")));

		mvc.perform(get(new URI("/anagrams/%20%20").getPath()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.statusCode", is(400)))
				.andExpect(jsonPath("$.message", is("400 - Bad Request")))
				.andExpect(jsonPath("$.details", hasItems("Not a valid input string to generate anagrams")));
	}
	
	@Test
	public void test_generated_anagram_with_valid_string() throws Exception {

		mvc.perform(get("/anagrams/ABC").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.anagrams", hasItems("abc","acb","bac", "bca", "cab","cba")));
	}


}
