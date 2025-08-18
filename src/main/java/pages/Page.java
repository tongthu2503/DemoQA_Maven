package pages;

import org.openqa.selenium.WebDriver;

import common.TestBase;

public class Page {
	
	public WebDriver driver;
	public TestBase testBase = new TestBase();
	
	public Page(WebDriver dr) {
		this.driver = dr;
		testBase.webDriver = dr;
	}
	
	public static AutomationPracticeFormPage automationPracticeFormPage;
	
	public AutomationPracticeFormPage goToAutomationPracticeFormPage() {
		driver.navigate().to("https://demoqa.com/automation-practice-form");
		return new AutomationPracticeFormPage(driver);
	}
	
	public void goToPage(String deeplink) {
	driver.navigate().to(deeplink);
	}
}
