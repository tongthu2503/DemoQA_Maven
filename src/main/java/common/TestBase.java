package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public WebDriver webDriver;
	public void openBrowser () {
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		webDriver = new ChromeDriver();
		webDriver.get("https://demoqa.com/");
		//expand browser
		webDriver.manage().window().maximize();
	}

}
