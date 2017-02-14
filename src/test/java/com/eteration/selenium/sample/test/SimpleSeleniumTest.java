package com.eteration.selenium.sample.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleSeleniumTest {

	
	
	private WebDriver webDriver;

	@Before
	public void setUp() throws Exception {
		
		
		//Downloaded latest  from  https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver
		System.setProperty("webdriver.chrome.driver", "/Users/murat/DEV/chromedriver");
		webDriver = new ChromeDriver();
	}
	
	
	@After
	public void tearDown() throws Exception {
		
		webDriver.close();
		webDriver.quit();
	}
	
	
	@Test
	public void test() {

	

		
	
		webDriver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
		
		webDriver.findElement(By.id("searchInput")).sendKeys("Lomboz");

		webDriver.findElement(By.id("searchInput")).submit();

		List<WebElement> testResults = webDriver.findElements(By.tagName("i"));
		
		
		boolean resultAvailable = testResults.get(testResults.size()-1).getText().contains("eteration");

		Assert.assertTrue(resultAvailable);

	}

}
