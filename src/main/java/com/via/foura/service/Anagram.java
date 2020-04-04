package com.via.foura.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * @author himadri
 * 
 * This class is the anagram service class with two method exposed to
 * users are checkAnagram and generate anagram
 */
@Service
public class Anagram implements AnagramService {

	/**
	 * check anagram method checks if two string are anagram of each other and it gets
	 * the generated anagram from isAnagram method.
	 */
	@Override
	public boolean checkAnagram(String stringA, String stringB) {
		return isAnagram(preprocess(stringA), preprocess(stringB));
	}

	/**
	 * isAnagram method solves the problem in O(n) time without having to declare a big counting array.
	 * It took the advantages of multiset from google guava
	 * @param string1
	 * @param string2
	 * @return
	 */
	private boolean isAnagram(String string1, String string2) {
		if (string1.length() != string2.length()) {
			return false;
		}

		Multiset<Character> multiset1 = HashMultiset.create();
		Multiset<Character> multiset2 = HashMultiset.create();
		for (int i = 0; i < string1.length(); i++) {
			multiset1.add(string1.charAt(i));
			multiset2.add(string2.charAt(i));
		}
		return multiset1.equals(multiset2);
	}

	
	private String preprocess(String source) {
		return source.replaceAll("\\s+", "").toLowerCase();
	}

	/**
	 * This method is responsible to return all the generated permutations of a given string
	 */
	@Override
	public List<String> produceAnagram(String stringA) {
		List<String> generatedList = new ArrayList<String>();
		GenerateAnagram generateAnagram = new GenerateAnagram();
		stringA = preprocess(stringA);
		generateAnagram.generate(stringA, 0, stringA.length() - 1, generatedList);
		return generatedList;
	}

}
