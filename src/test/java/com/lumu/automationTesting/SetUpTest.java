package com.lumu.automationTesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetUpTest {

	protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private ChromeDriver chromeDriver;
	By box = By.id("box");
	WebElement textBox;

	@BeforeMethod()
	public void openWordCounterPage() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver\\chromedriver.exe");
		chromeDriver = new ChromeDriver();
		driver.set(chromeDriver);
		driver.get().get("https://wordcounter.net/");
		driver.get().manage().window().maximize();
		textBox = driver.get().findElement(box);
	}

	@AfterMethod
	public void afterMethod() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}

	}
}
