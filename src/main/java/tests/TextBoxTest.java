package tests;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxTest extends TestCase{
	
	@Test
	public void submitDataSuccesfully() {
		String fullName = "demoQA";
		String email = "abc@gmail.com";
		String currentAddress = "Huyng Thuc Khang";
		String permanentAddress = "501";
		//Find + click
		HomePage homePage = new HomePage(base.webDriver);
		ElementsPage elementsPage = homePage.clickOnElements();
		TextBoxPage textBoxPage = elementsPage.clickOnTextBox();
		//Input and submit
		textBoxPage.inputData(fullName,email,currentAddress,permanentAddress);
		//Compare result
		String acutalFullName = textBoxPage.getActualValue(textBoxPage.lblName);
		String actualEmail = textBoxPage.getActualValue(textBoxPage.lblEmail);
		String actualCurrentAddress = textBoxPage.getActualValue(textBoxPage.lblCurrentAddress);
		String actualPermanentAddress = textBoxPage.getActualValue(textBoxPage.lblPermanentAddress);
		assertEquals(acutalFullName, fullName);
		assertEquals(actualEmail, email);
		assertEquals(actualCurrentAddress, currentAddress);
		assertEquals(actualPermanentAddress, permanentAddress);
	}
	
	@Test(dataProvider = "TextBoxData")
	public void validateEmailformat(String fullName, String email, String currentAddress, String permanentAddress) {
//		String fullName = "demoQA";
//		String email = "abcgmail.com";
//		String currentAddress = "Huyng Thuc Khang";
//		String permanentAddress = "501";
		HomePage homePage = new HomePage(base.webDriver);
		ElementsPage elementsPage = homePage.clickOnElements();
		TextBoxPage textBoxPage = elementsPage.clickOnTextBox();
		textBoxPage.inputData(fullName,email,currentAddress,permanentAddress);
		assertTrue(textBoxPage.checkHighLightField(textBoxPage.txtEmail, "class", "field-error"));
	}
	
//	@Test
//	public void validateEmailformatDomain() {
//		String fullName = "demoQA";
//		String email = "abc@gmail";
//		String currentAddress = "Huyng Thuc Khang";
//		String permanentAddress = "501";
//		HomePage homePage = new HomePage(base.webDriver);
//		ElementsPage elementsPage = homePage.clickOnElements();
//		TextBoxPage textBoxPage = elementsPage.clickOnTextBox();
//		textBoxPage.inputData(fullName,email,currentAddress,permanentAddress);
//		assertTrue(textBoxPage.checkHighLightField(textBoxPage.txtEmail, "class", "field-error"));
//
//	}
	
	@DataProvider(name = "TextBoxData")
	public String[][] createData(){
		String[][] textBoxData = new String[2][4];
		textBoxData[0][0] = "demoQA";
		textBoxData[0][1] = "abcgmail.com";
		textBoxData[0][2] = "Huyng Thuc Khang";
		textBoxData[0][3] = "501";
		
		textBoxData[1][0] = "demoQA";
		textBoxData[1][1] = "abc@gmail";
		textBoxData[1][2] = "Huyng Thuc Khang";
		textBoxData[1][3] = "501";
		return textBoxData;
	}
	
	
}

