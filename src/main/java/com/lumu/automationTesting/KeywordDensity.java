package com.lumu.automationTesting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class KeywordDensity {
	private Map<String, Integer> densities;
	private Map<String, Integer> densitiesListSort;
	private String inputText = "";

	public KeywordDensity(String stringText) {
		this.inputText = stringText;
	}
	
	public void keywordDensity() {

		inputText = inputText.toLowerCase();                   //O(1)
		String[] arrayText = inputText.split(" ");             //O(1)
		densities = new HashMap<>();                           //O(1)
		
		for (String word : arrayText) {
			
		    Pattern pattern = Pattern.compile("[^a-zA-Z]+");    //O(n)
		    Matcher matcher = pattern.matcher(word);            //O(n)
		    String wordFinal = matcher.replaceAll("");          //O(n)

			densities.merge(wordFinal, 1, Integer::sum);       //O(n)
			
		}
		densitiesSort();                                       //O(1)
	}
	
	
	private void densitiesSort() {
		//O(1)
		densitiesListSort  = densities.entrySet().stream()
			       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new));
		
	}
	
	public void printDensities() {
		densitiesListSort.forEach((key, value) -> System.out.printf("%-20s%-20s\n" , key+" : "  , value));
	}
	
	public Map<String, Integer> getDensitiesListSort() {
		keywordDensity();
		return densitiesListSort;
	}	
}