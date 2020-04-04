package com.via.foura.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class GenerateAnagramTest {

	GenerateAnagram generateAnagram = new GenerateAnagram();

	@Test
	public void testGenerateAanagram_wtih_a_valid_string() {
		String string = "ABC";
		List<String> result = new ArrayList<String>();
		generateAnagram.generate(string, 0, string.length() - 1, result);
		assertEquals(6, result.size());
		assertEquals(true, result.contains("ABC"));
		assertEquals(true, result.contains("ACB"));
		assertEquals(true, result.contains("BAC"));
		assertEquals(true, result.contains("BCA"));
		assertEquals(true, result.contains("CAB"));
		assertEquals(true, result.contains("CBA"));
	}
}
