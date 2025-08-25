package common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	public WebDriver webDriver;
	
	public void openBrowser () {
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		webDriver = new ChromeDriver();
		webDriver.get("https://demoqa.com/");
		//expand browser
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void inputText(By locator, CharSequence enter) {
		webDriver.findElement(locator).sendKeys(enter);
	}
	
//	public By getXpathByParam(String originalXpath, String value) {
//		By result = null;
//		String newXpath = originalXpath.replace("{@param",value);
//		result = By.xpath(newXpath);
//		return result;	
//	}
	
	public By getXpathByParam(String originalXpath, String value) {
		By result = null;
		String newXpath = originalXpath.replace("{@param}", value);
		result = By.xpath(newXpath);
		return result;	
	}
	
	public void clickOnElement(By locator) {
		webDriver.findElement(locator).click();
	}
	
//	public void clickOnRadiobutton(String originalXpath, String value) {
//		By newXpath = getXpathByParam(originalXpath, value);
//		clickOnElement(newXpath);
//	}
	
	public void clickOnRadiobutton(String originalXpath, String value) {
		if (!value.isEmpty()) {
			String newXpathString = originalXpath.replace("{@param}", value);
			By newXpath = By.xpath(newXpathString);
			clickOnElement(newXpath);
		}
	}
	
	/**
	 * Multiple check in checkbox
	 * @param originalXpath : example data: //label[text()='{@param}']
	 * @param value: multiple labels of all checkboxes: E.g "Reading, Sports"
	 */
	public void clickOnCheckBox(String originalXpath, String value) {
		String[] values = value.split(",");
		for(int i = 0; i < values.length; i++) {
			//Trim đầu và cuối chuỗi
			String cleanValue = values[i].trim();
			By newXpath = getXpathByParam(originalXpath, cleanValue);
			clickOnElement(newXpath);
		}
	}
	
	/**
	 * Select value in dropdown list
	 * @param locator
	 * @param visibleText
	 */
	public void selectByVisibleText(By locator, String visibleText) {
		WebElement drElement = webDriver.findElement(locator);
		Select drSelect = new Select(drElement);
//		drSelect.deSelectByContainsVisibleText(visibleText);
		drSelect.selectByContainsVisibleText(visibleText);
	}
	
	public void selectComboboxValue(By locator, String value) {
		clickOnElement(locator);
//		inputText(locator, value);
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
		By waitedLocator= By.xpath("//div[text()='" +value+ "']");
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(waitedLocator));
//		inputText(locator, Keys.ENTER);
		option.click();
	}
	
	/**
	 * Input multiple values to a combobox
	 * @param locator: of combobox
	 * @param value: String format = "value1, value 2, ...."
	 */
	public void inputComboBoxWithMultiData(By locator,String value) {
		if (!value.isEmpty()) {
			String[] values = value.split(",");
			for(int i = 0; i < values.length; i++) {
			inputText(locator, values[i].trim());
			inputText(locator, Keys.ENTER);
			}
		}
	}
	
	public void zoomOut(String percentageValue) {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("document.body.style.zoom= '" +percentageValue+ "'");
	}
	
	public void scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].scrollIntoView();", webDriver.findElement(locator));
	}
	
	public String getTextByLocator(String originalXpath, String fieldName) {
		String result = "";
		By newXpath = getXpathByParam(originalXpath, fieldName);
		result = webDriver.findElement(newXpath).getText();
		return result;
	}
	
	public void searchOnTable(By locator, String searchValue) {
		inputText(locator,searchValue);
		inputText(locator, Keys.ENTER);
	}
}
