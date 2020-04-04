package com.via.foura.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InputValidationTest {
	
	@Test
	public void test_validate_null_string() {
		assertEquals(false, InputValidation.isValidString(null));
	}
	
	@Test
	public void test_validate_with_whitespace_string() {
		assertEquals(false, InputValidation.isValidString(""));
		assertEquals(false, InputValidation.isValidString(" "));
		assertEquals(true, InputValidation.isValidString("ABC Def "));
	}
	
	@Test
	public void test_validate_with_special_character_string() {
		assertEquals(false, InputValidation.isValidString("*"));
		assertEquals(false, InputValidation.isValidString("%% *ABC"));
	}
	
	@Test
	public void test_validate_with_valid_string() {
		assertEquals(true, InputValidation.isValidString("ABC"));
		assertEquals(true, InputValidation.isValidString("ABC DEF"));
		assertEquals(true, InputValidation.isValidString("ABCDEF 	"));
		assertEquals(true, InputValidation.isValidString("123 	"));
		assertEquals(true, InputValidation.isValidString("123 	ABC"));

	}
}
