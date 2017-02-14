package com.eteration.selenium.sample.test;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SimpleSeleniumGridTest {

	private WebDriver webDriver;

	@Before
	public void setUp() throws Exception {

		//download server from http://www.seleniumhq.org/download/
		String Node = "http://localhost:4444/wd/hub";
		DesiredCapabilities cap = DesiredCapabilities.chrome();

		webDriver = new RemoteWebDriver(new URL(Node), cap);
	}

	@After
	public void tearDown() throws Exception {

		webDriver.close();
		webDriver.quit();
	}

	@Test
	public void test() {

		String URL = "http://academy.eteration.com/";

		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		webDriver.navigate().to(URL);
		List<WebElement> testResults = webDriver.findElements(By.tagName("a"));
		
		
		boolean resultAvailable = testResults.get(testResults.size()-1).getText().contains("Eteration");

		Assert.assertTrue(resultAvailable);

	}

}
