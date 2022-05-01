package com.lumu.automationTesting;


public class CountWordsAndCharacters {
	
	private int wordCount = 0;
	private String inputText = "";
	private int numberOfCharacters;
	
	public CountWordsAndCharacters(String inputText) {
		this.inputText = inputText;
	}

	private int countWordsStringTest() {
	
		char[] charactersInString = inputText.toCharArray();
		boolean isWord = false;
		int endString = inputText.length() - 1;
		for (int letter = 0; letter < inputText.length(); letter++) {
			if (letter != endString && Character.isLetter(charactersInString[letter])) {
				isWord = true;
			} else if (!Character.isLetter(charactersInString[letter]) && isWord) {
				wordCount++;
				isWord = false; 
			} else if (letter == endString && Character.isLetter(charactersInString[letter])) {
				wordCount++;
			}
		}
		return wordCount;
	}
	

	private int countCharactersStringTest() {

		numberOfCharacters = inputText.replace("\r\n", "").length();
		return numberOfCharacters;
	}

	public int getWordCount() {
		return countWordsStringTest();
	}
	
	public int getNumberOfCharacters() {
		return countCharactersStringTest();
	}
}