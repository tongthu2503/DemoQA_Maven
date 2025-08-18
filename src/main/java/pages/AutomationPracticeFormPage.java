package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	//Output
	public By studentNameValue = By.xpath("//*[@class = 'table-responsive']//tr[1]/td[2]");
	public By studentEmailValue = By.xpath("//*[@class = 'table-responsive']//tr[2]/td[2]");
	public By genderValue = By.xpath("//*[@class = 'table-responsive']//tr[3]/td[2]");
	public By mobileValue = By.xpath("//*[@class = 'table-responsive']//tr[4]/td[2]");
	public By dateOfBirthValue = By.xpath("//*[@class = 'table-responsive']//tr[5]/td[2]");
	public By subjectsValue = By.xpath("//*[@class = 'table-responsive']//tr[6]/td[2]");
	public By hobbiesValue = By.xpath("//*[@class = 'table-responsive']//tr[7]/td[2]");
	public By pictureValue = By.xpath("//*[@class = 'table-responsive']//tr[8]/td[2]");
	public By addressValue = By.xpath("//*[@class = 'table-responsive']//tr[9]/td[2]");
	public By stateAndCityValue = By.xpath("//*[@class = 'table-responsive']//tr[10]/td[2]");
	
	//contructor
		public AutomationPracticeFormPage(WebDriver dr) {
			super(dr);	
		}

	public void inputData(String firstName, String lastName, String email, String gender, String phone, String dateOfBirth, String subjects, 
			String hobbies, String uploadFile, String currentAddress, String state, String city) {
		testBase.zoomOut("60%");
		testBase.inputText(txtFirstName, firstName);
		testBase.inputText(txtLastName, lastName);
		testBase.inputText(txtUserEmail, email);
		testBase.clickOnRadiobutton(rdGenderXpath, gender);
		testBase.inputText(txtUserNumber, phone);	
		inputDate(dateOfBirth);
		testBase.scrollToElement(btnSubmit);
		testBase.inputComboBoxWithMultiData(cbSubjects, subjects);
		testBase.clickOnCheckBox(rdHobbiesXpath, hobbies);
		testBase.inputText(btnUploadPicture,uploadFile);
		testBase.inputText(txtCurrentAddress, currentAddress);
		testBase.selectComboboxValue(cbState, state);
		testBase.selectComboboxValue(cbCity, city);
		driver.findElement(btnSubmit).click();
	}
	
	public void inputAllOptionalFields(String email, String subjects, 
			String hobbies, String uploadFile, String currentAddress, String state, String city) {
		testBase.zoomOut("60%");
		testBase.inputText(txtUserEmail, email);
		testBase.scrollToElement(btnSubmit);
		testBase.inputComboBoxWithMultiData(cbSubjects, subjects);
		testBase.clickOnCheckBox(rdHobbiesXpath, hobbies);
		testBase.inputText(btnUploadPicture,uploadFile);
		testBase.inputText(txtCurrentAddress, currentAddress);
		testBase.selectComboboxValue(cbState, state);
		testBase.selectComboboxValue(cbCity, city);
		driver.findElement(btnSubmit).click();
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
	
	public boolean checkHighLightField(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		String borderColor = element.getCssValue("border-color").trim();
		System.out.print(borderColor);
		boolean isHighLight = borderColor.equalsIgnoreCase("#dc3545") || 
                borderColor.equalsIgnoreCase("rgb(220, 53, 69)");
		return isHighLight;
	}
}
