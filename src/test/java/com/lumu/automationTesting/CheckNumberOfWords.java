package com.lumu.automationTesting;

import org.testng.annotations.Test;

import junit.framework.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckNumberOfWords extends SetUpTest{

	int numberOfWordStringTest;

	@Test(dataProvider = "testString", dataProviderClass = DataProviderWordCounter.class)
	public void checkNumberOfWords(String inputText) {
		
		CountWordsAndCharacters numberOfWord = new CountWordsAndCharacters(inputText);
		textBox.sendKeys(inputText);

		numberOfWordStringTest = numberOfWord.getWordCount();

		//Check count of word in Details
		
		WebElement detailsResult = new WebDriverWait(driver.get(), Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(By.id("word_count")));

		int countWordApp = Integer.parseInt(detailsResult.getText());

		Assert.assertTrue(
				"La cantidad de palabras esperada era: " + numberOfWordStringTest + " . Se obtuvo: " + countWordApp,
				numberOfWordStringTest == countWordApp);
		
		//Check count of word in title
		WebElement titleResult = new WebDriverWait(driver.get(), Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top_counter\"]/div[1]/h1/span")));

		String titleResultTest = titleResult.getText();
		String[] titleResultTestArray = titleResultTest.split(" ");
		int countWordInTitleApp = Integer.parseInt(titleResultTestArray[0]);


		Assert.assertTrue(
				"La cantidad de palabras esperada era: " + numberOfWordStringTest + " . Se obtuvo: " + countWordInTitleApp,
				numberOfWordStringTest == countWordInTitleApp);
		
		//Check count of word in footer
		
		WebElement footerResult = new WebDriverWait(driver.get(), Duration.ofSeconds(10)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"editor_container\"]/div[6]/div/div[1]/h4/span")));

		String footerResultArray = footerResult.getText();
		String[] footerResultTestArray = footerResultArray.split(" ");
		int countWordInFooterApp = Integer.parseInt(footerResultTestArray[0]);

		Assert.assertTrue(
				"La cantidad de palabras esperada era: " + numberOfWordStringTest + " . Se obtuvo: " + countWordInFooterApp,
				numberOfWordStringTest == countWordInFooterApp);
		
	}
}