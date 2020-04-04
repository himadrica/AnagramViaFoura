package com.via.foura.app.response;

/**
 * @author himadri
 * 
 * This is the response pojo class for checking two strings if
 * they are anagrams of each other
 */
public class AnagramCheckResponse {

	private boolean areAnagrams;

	public AnagramCheckResponse(boolean areAnagrams) {
		this.areAnagrams = areAnagrams;
	}

	public boolean getAreAnagrams() {
		return areAnagrams;
	}
}