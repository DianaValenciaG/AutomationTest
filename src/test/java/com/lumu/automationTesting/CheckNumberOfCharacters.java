package com.lumu.automationTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class CheckNumberOfCharacters extends SetUpTest {

	int numberOfCharactersStringTest;
	
	@Test(dataProvider = "testString", dataProviderClass = DataProviderWordCounter.class)
	public void checkNumberOfCharacters(String inputText) {

		textBox.sendKeys(inputText);
		CountWordsAndCharacters numberOfWord = new CountWordsAndCharacters(inputText);
		numberOfCharactersStringTest = numberOfWord.getNumberOfCharacters();

		//check count characters in Details 
		
		WebElement detailsResult = new WebDriverWait(driver.get(), Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(By.id("character_count")));

		int countCharactersApp = Integer.parseInt(detailsResult.getText());
		Assert.assertTrue("The count of characters expected was: " + numberOfCharactersStringTest + " . It was obtained: "
				+ countCharactersApp, numberOfCharactersStringTest == countCharactersApp);
		
		//check count characters in Title 
		
		WebElement titleResult = new WebDriverWait(driver.get(), Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top_counter\"]/div[1]/h1/span")));

		String titleResultTest = titleResult.getText();
		String[] titleResultTestArray = titleResultTest.split(" ");
		int countCharactersInTitleApp = Integer.parseInt(titleResultTestArray[2]);

		Assert.assertTrue("The count of characters expected was: " + numberOfCharactersStringTest + " . It was obtained: "
				+ countCharactersInTitleApp, numberOfCharactersStringTest == countCharactersInTitleApp);
		
		//check count characters in Footer
		
		WebElement footerResult = new WebDriverWait(driver.get(), Duration.ofSeconds(10)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"editor_container\"]/div[6]/div/div[1]/h4/span")));

		String footerResultApp = footerResult.getText();
		String[] footerResultArray = footerResultApp.split(" ");
		int countCharacterInFootersApp = Integer.parseInt(footerResultArray[2]);

		Assert.assertTrue("The count of characters expected was: " + numberOfCharactersStringTest + " . It was obtained: "
				+ countCharacterInFootersApp, numberOfCharactersStringTest == countCharacterInFootersApp);
	}

}
