package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
	By lblElements = By.xpath("//h5[text()='Elements']");
	public HomePage(WebDriver dr) {
		super(dr);
	}
	
	public ElementsPage clickOnElements() {
		driver.findElement(lblElements).click();
		return new ElementsPage(driver);
	}

}
