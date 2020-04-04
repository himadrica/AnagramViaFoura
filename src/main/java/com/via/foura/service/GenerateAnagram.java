package com.via.foura.service;

import java.util.List;

/**
 * @author himadri
 *
 */
public class GenerateAnagram {
	
	/**
	 * This recursive method generates all the permutations of a given string
	 * 
	 * 
	 * @param str string to calculate permutation for
	 */
	public void generate(String str, int startingInex, int endIndex, List<String> generatedList) {
		if (startingInex == endIndex)
			generatedList.add(str);
		else {
			for (int i = startingInex; i <= endIndex; i++) {
				str = swap(str, startingInex, i);
				generate(str, startingInex + 1, endIndex, generatedList);
				str = swap(str, startingInex, i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * 
	 * @return swapped string
	 */
	private String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
