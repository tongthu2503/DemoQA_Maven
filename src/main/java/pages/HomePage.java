package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
	By lblElements = By.xpath("//h5[text()='Elements']");
	By lblForms = By.xpath("//div[@class='header-wrapper' and contains(., 'Forms')]");
	public HomePage(WebDriver dr) {
		super(dr);
	}
	
	public ElementsPage clickOnElements() {
		scrollToElement(lblElements);
		driver.findElement(lblElements).click();
		return new ElementsPage(driver);
	}
	
	public AutomationPracticeFormPage clickOnForms() {
		driver.findElement(lblForms).click();
		return new AutomationPracticeFormPage(driver);
	}
	
	public void scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
	}

}
