package com.lumu.automationTesting;

import java.util.List;
import java.util.Map;
import java.time.Duration;
import java.util.Iterator;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class CheckDensityWords extends SetUpTest {

	private int keywordsAppSize;
	private String[] words;
	private int[] countWords;

	@Test(dataProvider = "testStringDensities", dataProviderClass = DataProviderWordCounter.class)
	public void checkDensityWords(String inputText) {
		textBox.sendKeys(inputText);

		KeywordDensity keywordDensity = new KeywordDensity(inputText);
		Map<String, Integer> keyWordDensityMap = keywordDensity.getDensitiesListSort();
		int densitiesMapSize = keyWordDensityMap.size();
		catchDensitiesApp();

		Iterator<Map.Entry<String, Integer>> entries = keyWordDensityMap.entrySet().iterator();
		int iteratorDensities = 0;

		Assert.assertTrue("La cantidad de keywords es diferente. Cantidad Keywords esperado " + densitiesMapSize
				+ " Keywords obtenido: " + keywordsAppSize, densitiesMapSize == keywordsAppSize);

		while (entries.hasNext() && iteratorDensities < 3) {
			Map.Entry<String, Integer> entry = entries.next();

			Assert.assertTrue("No se encontro la llave: Palabra: "+ entry.getKey() + " Cantidad: " + entry.getValue().intValue(),
					buscarPalabra(entry.getKey(), entry.getValue().intValue()));
			iteratorDensities++;
		}
	}

	public boolean buscarPalabra(String word, int count) {

		int tamano = words.length; 

		for (int i = 0; i < tamano; i++) {
			if (word.equalsIgnoreCase(words[i]) && count == countWords[i]) {
				return true;
			}
		}
		return false;
	}

	public void catchDensitiesApp() {

		WebElement densitiesElement = new WebDriverWait(driver.get(), Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("kwd-accordion-data")));

		List<WebElement> elements = densitiesElement.findElements(By.tagName("a"));
		keywordsAppSize = elements.size();

		words = new String[keywordsAppSize];
		countWords = new int[keywordsAppSize];

		String word;
		String[] badge;
		int iterator = 0;
		int countWord = 0;

		while (iterator < keywordsAppSize) {
			List<WebElement> spanElements = elements.get(iterator).findElements(By.tagName("span"));

			badge = spanElements.get(0).getText().split(" ");
			word = spanElements.get(1).getText();
			countWord = Integer.parseInt(badge[0]);
			words[iterator] = word;
			countWords[iterator] = countWord;
			iterator++;
		}

	}

}