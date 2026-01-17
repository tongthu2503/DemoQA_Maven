package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.AutomationPracticeFormPage;
import pages.ThanksForSubmitting;
import tests.models.StudentRegistration;

public class AutomationPracticeFormTest extends TestCase{
	
//	@Test
//	public void submitDataSuccessFully() {
//		//Data
//		String firstName = "Nguyễn Văn";
//		String lastName = "Linh";
//		String email = "abc@gmail.com";
//		String gender = "Female";
//		String mobile = "0987654321";
//		String dateOfBirth = "12 Sep 2000";
//		String subjects = "Maths, English";
//		String hobbies = "Sports, Reading";
//		String picture = System.getProperty("user.dir") + "/testcases/testData/test.jpg";
//		String currentAddress = "55 HTK";
//		String state = "NCR";
//		String city = "Delhi";
//		//Call input data
//		AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage(base.webDriver);
//		automationPracticeFormPage.goToAutomationPracticeFormPage();
//		automationPracticeFormPage.inputData(firstName, lastName, email, gender, mobile, dateOfBirth, subjects, hobbies, picture, currentAddress, state, city);
//		//Check result on table pop-up
//		String actualstudentName = automationPracticeFormPage.getActualValue(automationPracticeFormPage.studentNameValue);
//		assertEquals(actualstudentName, firstName.trim().concat(" ").concat(lastName.trim()));
//		String actualEmail = automationPracticeFormPage.getActualValue(automationPracticeFormPage.studentEmailValue);
//		assertEquals(actualEmail,email);
//		String actualGender = automationPracticeFormPage.getActualValue(automationPracticeFormPage.genderValue);
//		assertEquals(actualGender, gender);
//		String actualMobile = automationPracticeFormPage.getActualValue(automationPracticeFormPage.mobileValue);
//		assertEquals(actualMobile, mobile);
//		String actualdateOfBirth = automationPracticeFormPage.getActualValue(automationPracticeFormPage.dateOfBirthValue);
//		assertEquals(actualdateOfBirth, automationPracticeFormPage.dateFormat(dateOfBirth));
//		String actualSubjects = automationPracticeFormPage.getActualValue(automationPracticeFormPage.subjectsValue);
//		assertEquals(actualSubjects, subjects);
//		String actualHobbies = automationPracticeFormPage.getActualValue(automationPracticeFormPage.hobbiesValue);
//		assertEquals(actualHobbies, hobbies);
//		String actualPicture = automationPracticeFormPage.getActualValue(automationPracticeFormPage.pictureValue);
//		assertEquals(actualPicture, automationPracticeFormPage.getFileName(picture));
//		String actualcurrentAddress = automationPracticeFormPage.getActualValue(automationPracticeFormPage.addressValue);
//		assertEquals(actualcurrentAddress, currentAddress);
//		String actualStateAndCity = automationPracticeFormPage.getActualValue(automationPracticeFormPage.stateAndCityValue);
//		assertEquals(actualStateAndCity, state.trim().concat(" ").concat(city.trim()));
//	}
	
	@Test
	public void submitDataSuccessFully1() {
		//Data
		StudentRegistration studentRegistration = new StudentRegistration(); 
		studentRegistration.setFirstName("Nguyễn Văn");
		studentRegistration.setLastName("Linh");
		studentRegistration.setEmail("abc@gmail.com");
		studentRegistration.setGender("Female");
		studentRegistration.setPhone("0987654321");
		studentRegistration.setDateOfBirth("12 Sep 2000");
		studentRegistration.setSubjects("Maths, English");
		studentRegistration.setHobbies("Sports, Reading");
		studentRegistration.setUploadFile(System.getProperty("user.dir") + "/testcases/testData/test.jpg");
		studentRegistration.setCurrentAddress("55 HTK");
		studentRegistration.setState("NCR");
		studentRegistration.setCity("Delhi");
		//Call input data
		AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage(base.webDriver);
		automationPracticeFormPage.goToAutomationPracticeFormPage();
		automationPracticeFormPage.inputData(studentRegistration);
		ThanksForSubmitting  thanksForSubmitting = automationPracticeFormPage.submitSuccessfully();
		//Check result on table pop-up
		
		String actualStudentName = base.getTextByLocator(thanksForSubmitting.fieldValueXpath, "Student Name");
		assertEquals(actualStudentName, studentRegistration.getFirstName() + " " + studentRegistration.getLastName());
		String actualStudentEmail = base.getTextByLocator(thanksForSubmitting.fieldValueXpath, "Student Email");
		assertEquals(actualStudentEmail, studentRegistration.getEmail());
		String actualGender = base.getTextByLocator(thanksForSubmitting.fieldValueXpath, "Gender");
		assertEquals(actualGender, studentRegistration.getGender());
		String actualMobile = base.getTextByLocator(thanksForSubmitting.fieldValueXpath, "Mobile");
		assertEquals(actualMobile, studentRegistration.getPhone());
		String actualDateOfBirth = base.getTextByLocator(thanksForSubmitting.fieldValueXpath, "Date of Birth");
		assertEquals(actualDateOfBirth, automationPracticeFormPage.dateFormat(studentRegistration.getDateOfBirth()));
		String actualSubjects = base.getTextByLocator(thanksForSubmitting.fieldValueXpath, "Subjects");
		assertEquals(actualSubjects, studentRegistration.getSubjects());
		String actualHobbies = base.getTextByLocator(thanksForSubmitting.fieldValueXpath, "Hobbies");
		assertEquals(actualHobbies, studentRegistration.getHobbies());
		String actualPicture = base.getTextByLocator(thanksForSubmitting.fieldValueXpath, "Picture");
		assertEquals(actualPicture, automationPracticeFormPage.getFileName(studentRegistration.getUploadFile()));
		String actualAddress = base.getTextByLocator(thanksForSubmitting.fieldValueXpath, "Address");
		assertEquals(actualAddress, studentRegistration.getCurrentAddress());
		String actualStateAndCity	 = base.getTextByLocator(thanksForSubmitting.fieldValueXpath, "State and City");
		assertEquals(actualStateAndCity, studentRegistration.getState() +" " + studentRegistration.getCity());
	}
	@Test
	public void submitBlankAllRequiredFields() {
		
		AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage(base.webDriver);
		automationPracticeFormPage.goToAutomationPracticeFormPage();
		automationPracticeFormPage.submitUnsuccessfully();
		assertTrue(automationPracticeFormPage.checkHighLightField1(automationPracticeFormPage.txtFirstNameInvalid));
		assertTrue(automationPracticeFormPage.checkHighLightField1(automationPracticeFormPage.txtLastNameInvalid));
		assertTrue(automationPracticeFormPage.checkHighLightField1(automationPracticeFormPage.txtMobileInvalid));
		assertTrue(automationPracticeFormPage.checkHighlightFields(automationPracticeFormPage.rdGenderInvalid));
	}
}
