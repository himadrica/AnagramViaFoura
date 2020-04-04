package com.via.foura.app.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author himadri
 * 
 * This pojo class is the response entity for generated anagrams
 */
public class AnagramGenerateResponse {
	
	private List<String> anagrams;

	public AnagramGenerateResponse(List<String> anagrams) {
		this.anagrams = anagrams;
	}

	@JsonProperty("anagrams")
	public List<String> getAreAnagrams() {
		return anagrams;
	}
}