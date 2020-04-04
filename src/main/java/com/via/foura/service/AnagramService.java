package com.via.foura.service;

import java.util.List;

public interface AnagramService {
	public boolean checkAnagram(String stringA, String stringB);
	public List<String> produceAnagram(String stringA);
}
