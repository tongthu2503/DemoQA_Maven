package tests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxTest extends TestCase{
	@Test
	public void submitDataSuccesfully() {
		//Find + click
		HomePage homePage = new HomePage(base.webDriver);
		ElementsPage elementsPage = homePage.clickOnElements();
		TextBoxPage textBoxPage = elementsPage.clickOnTextBox();
		//Find + input value
		textBoxPage.inputData();
	}
	
	@Test
	public void validateEmailFormat() {
		//Find + click
		base.webDriver.findElement(By.xpath("//h5[text()='Elements']")).click();
		base.webDriver.findElement(By.xpath("//span[text()='Text Box']")).click();
		//Find + input value
		base.webDriver.findElement(By.id("userName")).sendKeys("demoQA");
		base.webDriver.findElement(By.id("userEmail")).sendKeys("abc@gmail.com");
		base.webDriver.findElement(By.id("currentAddress")).sendKeys("Huyng Thuc Khang");
		base.webDriver.findElement(By.id("permanentAddress")).sendKeys("501");
		base.webDriver.findElement(By.id("submit")).click();
	}
	
}

