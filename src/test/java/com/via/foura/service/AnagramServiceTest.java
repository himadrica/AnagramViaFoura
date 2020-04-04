package com.via.foura.service;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramServiceTest {
	AnagramService anagram = new Anagram();
	
	// null string and empty string validation is done in inputValidation
	// The valid strings are alphanumeric
	
	@Test
	public void test_are_anagrams() {
		assertEquals(true,anagram.checkAnagram("iceman", "cinema"));
		assertEquals(true,anagram.checkAnagram("Iceman", "Cinema"));
		assertEquals(true,anagram.checkAnagram("ABCD", "DCAb"));
		assertEquals(true,anagram.checkAnagram("aabbdd", "ddbbaa"));
		assertEquals(false,anagram.checkAnagram("aabbdd", "ddbaaa"));
		assertEquals(false,anagram.checkAnagram("Iceman", "Cinama"));
		assertEquals(false,anagram.checkAnagram("Iceman", "Cnema"));
	}
	
	@Test
	public void test_generated_anagrams() {
		List<String> result = anagram.produceAnagram("ABC");
		assertEquals(6, result.size());
		assertEquals(true, result.contains("abc"));
		assertEquals(true, result.contains("acb"));
		assertEquals(true, result.contains("bac"));
		assertEquals(true, result.contains("bca"));
		assertEquals(true, result.contains("cab"));
		assertEquals(true, result.contains("cba"));
	}
}
