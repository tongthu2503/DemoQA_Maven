package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AutomationPracticeFormPage;



public class AutomationPracticeFormTest extends TestCase{
	
	@Test
	public void submitDataSuccessFully() {
		//Data
		String firstName = "Nguyễn Văn";
		String lastName = "Linh";
		String email = "abc@gmail.com";
		String gender = "Female";
		String mobile = "0987654321";
		String dateOfBirth = "12 Sep 2000";
		String subjects = "Maths, English";
		String hobbies = "Sports, Reading";
		String picture = System.getProperty("user.dir") + "/testcases/testData/test.jpg";
		String currentAddress = "55 HTK";
		String state = "NCR";
		String city = "Delhi";
		//Call input data
		AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage(base.webDriver);
		automationPracticeFormPage.goToAutomationPracticeFormPage();
		automationPracticeFormPage.inputData(firstName, lastName, email, gender, mobile, dateOfBirth, subjects, hobbies, picture, currentAddress, state, city);
		//Check result on table pop-up
		String actualstudentName = automationPracticeFormPage.getActualValue(automationPracticeFormPage.studentNameValue);
		assertEquals(actualstudentName, firstName.trim().concat(" ").concat(lastName.trim()));
		String actualEmail = automationPracticeFormPage.getActualValue(automationPracticeFormPage.studentEmailValue);
		assertEquals(actualEmail,email);
		String actualGender = automationPracticeFormPage.getActualValue(automationPracticeFormPage.genderValue);
		assertEquals(actualGender, gender);
		String actualMobile = automationPracticeFormPage.getActualValue(automationPracticeFormPage.mobileValue);
		assertEquals(actualMobile, mobile);
		String actualdateOfBirth = automationPracticeFormPage.getActualValue(automationPracticeFormPage.dateOfBirthValue);
		assertEquals(actualdateOfBirth, automationPracticeFormPage.dateFormat(dateOfBirth));
		String actualSubjects = automationPracticeFormPage.getActualValue(automationPracticeFormPage.subjectsValue);
		assertEquals(actualSubjects, subjects);
		String actualHobbies = automationPracticeFormPage.getActualValue(automationPracticeFormPage.hobbiesValue);
		assertEquals(actualHobbies, hobbies);
		String actualPicture = automationPracticeFormPage.getActualValue(automationPracticeFormPage.pictureValue);
		assertEquals(actualPicture, automationPracticeFormPage.getFileName(picture));
		String actualcurrentAddress = automationPracticeFormPage.getActualValue(automationPracticeFormPage.addressValue);
		assertEquals(actualcurrentAddress, currentAddress);
		String actualStateAndCity = automationPracticeFormPage.getActualValue(automationPracticeFormPage.stateAndCityValue);
		assertEquals(actualStateAndCity, state.trim().concat(" ").concat(city.trim()));
	}
	
	@Test
	public void submitBlankAllRequiredFields() {
		//Data
		String email = "abc@gmail.com";
		String subjects = "Maths, English";
		String hobbies = "Sports, Reading";
		String picture = System.getProperty("user.dir") + "/testcases/testData/test.jpg";
		String currentAddress = "55 HTK";
		String state = "Haryana";
		String city = "Panipat";
		//Call input data
		AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage(base.webDriver);
		automationPracticeFormPage.goToAutomationPracticeFormPage();
		automationPracticeFormPage.inputAllOptionalFields(email, subjects, hobbies, picture, currentAddress, state, city);
		//Check result on table pop-up
		assertTrue(automationPracticeFormPage.checkHighLightField(automationPracticeFormPage.txtFirstName));
		assertTrue(automationPracticeFormPage.checkHighLightField(automationPracticeFormPage.txtLastName));
		assertTrue(automationPracticeFormPage.checkHighLightField(automationPracticeFormPage.txtUserNumber));
	}
}
