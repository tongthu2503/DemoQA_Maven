package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends Page{

	public TextBoxPage(WebDriver dr) {
		super(dr);
	}
	
	public void inputData() {
		driver.findElement(By.id("userName")).sendKeys("demoQA");
		driver.findElement(By.id("userEmail")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Huyng Thuc Khang");
		driver.findElement(By.id("permanentAddress")).sendKeys("501");
		driver.findElement(By.id("submit")).click();
	}
}
