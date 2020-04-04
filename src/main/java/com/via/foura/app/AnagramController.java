package com.via.foura.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.via.foura.app.response.AnagramCheckResponse;
import com.via.foura.app.response.AnagramGenerateResponse;
import com.via.foura.exception.AnagramException;
import com.via.foura.service.AnagramService;
import com.via.foura.validation.InputValidation;

/**
 * @author himadri
 *	
 * The anagram controller is the entry point for checking and generating anagrams
 * 
 */
@RestController
public class AnagramController {

	@Autowired
	AnagramService anagramService;

	/**
	 * This method generates all the anagrams supplied in the path variable string
	 * 
	 * @param string1
	 * @return
	 */
	@RequestMapping("/anagrams/{string1}")
	public ResponseEntity<AnagramGenerateResponse> produceAnagram(@PathVariable String string1) {
		List<String> result = new ArrayList<String>();

		if (InputValidation.isValidString(string1)) {
			result = anagramService.produceAnagram(string1);
		} else {
			throw new AnagramException("Not a valid input string to generate anagrams");
		}

		return new ResponseEntity<AnagramGenerateResponse>(new AnagramGenerateResponse(result), HttpStatus.OK);
	}

	/**
	 * This method checks two strings if they are anagram of each other
	 * @param string1
	 * @param string2
	 * @return
	 */
	@RequestMapping("/anagrams/{string1}/{string2}")
	public ResponseEntity<AnagramCheckResponse> isAnagram(@PathVariable String string1, @PathVariable String string2) {
		boolean result = false;
		if (InputValidation.isValidString(string1) && InputValidation.isValidString(string2)) {
			result = anagramService.checkAnagram(string1, string2);
		} else {
			throw new AnagramException("Invalid input strings to check anagrams");
		}

		return new ResponseEntity<AnagramCheckResponse>(new AnagramCheckResponse(result), HttpStatus.OK);
	}
}
