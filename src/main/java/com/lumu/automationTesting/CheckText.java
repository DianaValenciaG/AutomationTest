package com.lumu.automationTesting;

public class CheckText {

	public static void main(String[] args) {
	    ReadFile file = new ReadFile();
	    String stringText = (file.readFile());
	    
	    CountWordsAndCharacters  countWordsAndCharacters = new  CountWordsAndCharacters(stringText);
	    System.out.printf("%-20s%-20s\n", countWordsAndCharacters.getWordCount() , "words");
	    System.out.printf("%-20s%-20s\n", countWordsAndCharacters.getNumberOfCharacters() , "characters");   
	    
	    KeywordDensity densities = new KeywordDensity(stringText);
	    densities.getDensitiesListSort();
	    densities.printDensities();
	}
}