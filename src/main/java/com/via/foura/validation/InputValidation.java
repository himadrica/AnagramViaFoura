package com.via.foura.validation;

import com.via.foura.exception.AnagramException;

import io.micrometer.core.instrument.util.StringUtils;

/**
 * @author himadri
 * 
 * Path parameters input validations
 */
public class InputValidation {

	/**
	 * I assumed the valid strings are below
	 * 	= not null
	 *  = not empty
	 *  = alphanumeric with whitespace
	 *  
	 * @param string
	 * @return
	 * @throws AnagramException
	 */
	public static boolean isValidString(String string) {
		if (StringUtils.isBlank(string))
			return false;

		if (!isStringOnlyAlphabet(string))
			return false;
		return true;
	}

	/**
	 * consider the rearrangement of alphanumeric with whitespace
	 * 
	 * @param source
	 * @return
	 */
	private static boolean isStringOnlyAlphabet(String str) {
		return str.matches("^[a-zA-Z0-9\\s]*$");
	}

}
