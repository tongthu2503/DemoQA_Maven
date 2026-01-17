package pages;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.models.StudentRegistration;

public class AutomationPracticeFormPage extends Page{
	//Input
	public By txtFirstName = By.id("firstName");
	public By txtLastName = By.id("lastName");
	By txtUserEmail = By.id("userEmail");
	String rdGenderXpath = "//label[text()='{@param}']";
	public By txtUserNumber = By.id("userNumber");
	By txtDateOfBirth = By.id("dateOfBirthInput");
	By drYear = By.xpath("//*[@class = 'react-datepicker__year-select']");
	By drMonth = By.xpath("//*[@class = 'react-datepicker__month-select']");
	String lblDateXpath = "//*[@class='react-datepicker__week']//div[contains(text(), '{@param}')]";
	By cbSubjects = By.id("subjectsInput");
	String rdHobbiesXpath = "//label[text()='{@param}']";
	By btnUploadPicture = By.id("uploadPicture");
	By txtCurrentAddress = By.id("currentAddress");
	By cbState = By.id("state");
	By cbCity = By.id("city");
	By btnSubmit = By.id("submit");
	public By txtFirstNameInvalid = By.cssSelector("input#firstName.form-control:invalid");
	public By txtLastNameInvalid = By.cssSelector("input#lastName.form-control:invalid");
	public By txtMobileInvalid = By.cssSelector("input#userNumber.form-control:invalid");
	public By rdGenderInvalid = By.cssSelector("input:invalid~.custom-control-label");
	//contructor
	public AutomationPracticeFormPage(WebDriver dr) {
		super(dr);	
	}

	public void inputData(StudentRegistration studentRegistration) {
		testBase.zoomOut("60%");
		testBase.inputText(txtFirstName, studentRegistration.getFirstName());
		testBase.inputText(txtLastName, studentRegistration.getLastName());
		testBase.inputText(txtUserEmail, studentRegistration.getEmail());
		testBase.clickOnRadiobutton(rdGenderXpath, studentRegistration.getGender());
		testBase.inputText(txtUserNumber, studentRegistration.getPhone());	
		inputDate(studentRegistration.getDateOfBirth());
		testBase.scrollToElement(btnSubmit);
		testBase.inputComboBoxWithMultiData(cbSubjects, studentRegistration.getSubjects());
		testBase.clickOnCheckBox(rdHobbiesXpath, studentRegistration.getHobbies());
		testBase.inputText(btnUploadPicture,studentRegistration.getUploadFile());
		testBase.inputText(txtCurrentAddress, studentRegistration.getCurrentAddress());
		testBase.selectComboboxValue(cbState, studentRegistration.getState());
		testBase.selectComboboxValue(cbCity, studentRegistration.getCity());
	}
	
	public void inputDate(String dateOfBirth) {
		String[] dateOfBirths = dateOfBirth.split(" ");
		testBase.clickOnElement(txtDateOfBirth);
		testBase.selectByVisibleText(drYear, dateOfBirths[2]);
		testBase.selectByVisibleText(drMonth, dateOfBirths[1]);
		By lblDate = testBase.getXpathByParam(lblDateXpath, dateOfBirths[0]);
		testBase.clickOnElement(lblDate);
	}
	
	public String getActualValue(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		String originalStr = element.getText().trim();
		return originalStr;
	}
	
	public String getFileName(String filePath) {
		int lastSeparatorIndex = Math.max(filePath.lastIndexOf("/"), filePath.lastIndexOf("\\"));
		return filePath.substring(lastSeparatorIndex + 1);
	}
	
	public String dateFormat(String date) {
		date = date.replace(",", "").trim();
        String[] parts = date.split(" ");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];
        //Change sort month to full month
        switch(month) {
        case "Jan":
            month = "January";
            break;
        case "Feb":
            month = "February";
            break;
        case "Mar":
            month = "March";
            break;
        case "Apr":
            month = "April";
            break;   
        case "May":
            month = "May";
            break;
        case "Jun":
            month = "June";
            break;
        case "Jul":
            month = "July";
            break;
        case "Aug":
            month = "August";
            break;  
        case "Sep":
            month = "September";
            break;
        case "Oct":
            month = "October";
            break;     
        case "Nov":
            month = "November";
            break;
        case "Dec":
            month = "December";
            break;
        }
        return day + " " + month + "," + year;
	}
	
	public String checkHighLightField(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
		String borderColor = element.getCssValue("border-color").trim();        
		return borderColor;
	}
	
	public boolean isCheckRequiredFields(ArrayList<By> locators) {
		boolean isChecked = false;
		int count = 0;
		for(By locator:locators) {
			String actualCSS = checkHighLightField(locator);
			System.out.println(actualCSS);
			if (actualCSS.equalsIgnoreCase("#dc3545") || actualCSS.equalsIgnoreCase("rgb(209, 175, 183)") || actualCSS.equalsIgnoreCase("rgb(208, 189, 196)") ) {
			count = count + 1;
		}
		System.out.println(count);
		}
		if (count == locators.size()) {
			isChecked = true;
		}
		return isChecked;
	}
	
	public boolean checkHighLightField1(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		if (element.isDisplayed())
			{return true;}
		else { return false;}
	}
	
	public boolean checkHighlightFields(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		for(WebElement e: elements) {
			if (!e.isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	public void submitUnsuccessfully() {
		testBase.clickOnElement(btnSubmit);
	}
	
	public ThanksForSubmitting submitSuccessfully() {
		testBase.clickOnElement(btnSubmit);
		return new ThanksForSubmitting(driver);
	}
	
}
