package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends Page{
	By lblTextBox = By.xpath("//span[text()='Text Box']");
	public ElementsPage(WebDriver dr) {
		super(dr);
	}

	public TextBoxPage clickOnTextBox() {
		
		driver.findElement(lblTextBox).click();
		return new TextBoxPage(driver);
	}

}
