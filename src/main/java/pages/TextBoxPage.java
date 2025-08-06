package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage extends Page{
	By txtFullName = By.id("userName");
	public By txtEmail = By.id("userEmail");
	By txtCurrentAddress = By.id("currentAddress");
	By txtPermanentAddress = By.id("permanentAddress");
	By btnSubmit = By.id("submit");
	public By lblName = By.id("name");
	public By lblEmail = By.id("email");
	public By lblCurrentAddress = By.xpath("//p[@id='currentAddress']");
	public By lblPermanentAddress = By.xpath("//p[@id='permanentAddress']");
	
	public TextBoxPage(WebDriver dr) {
		super(dr);
	}
	
	public void scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
	}
	
	public void inputData(String fullName, String email, String currentAddress, String permanentAddress) {
		
		driver.findElement(txtFullName).sendKeys(fullName);
		driver.findElement(txtEmail).sendKeys(email);
		driver.findElement(txtCurrentAddress).sendKeys(currentAddress);
		driver.findElement(txtPermanentAddress).sendKeys(permanentAddress);
		// Scroll tìm Submit button
		scrollToElement(btnSubmit);
		driver.findElement(btnSubmit).click();
	}
	public String getActualValue(By locator) {
		String originalStr = driver.findElement(locator).getText();
		String[] originalArr = originalStr.split(":");
		String actualValue = originalArr[1];
		return actualValue;
	}
	
	public boolean checkHighLightField(By locator, String attributeName, String expectedValue) {
		String attributeValue = driver.findElement(locator).getAttribute(attributeName);
		boolean isChecked = true;
		if (!attributeValue.contains(expectedValue)) {
			isChecked = false;
		}
		return isChecked;
	
	}
}
