package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import common.TestBase;
import pages.WebTablesPage;

public class WebablesTest extends TestCase{
	
	@Test
	public void addAccountSuccessFully() {
		
		String firstName = "Nguyễn Văn";
		String lastName = "Linh";
		String email = "Test@gmail.com";
		String age = "23";
		String salary = "15600000";
		String department = "Kế toán";
		
		WebTablesPage webTablePage = new WebTablesPage(base.webDriver);
		webTablePage.goToPage("https://demoqa.com/webtables");
		webTablePage.addStaffInfo(firstName, lastName, email, age, salary, department);
		webTablePage.searchOnTable(webTablePage.txtSearchBox, firstName);
		assertEquals(base.getTextByLocator(webTablePage.clfNameXpath, firstName),firstName);
		assertEquals(base.getTextByLocator(webTablePage.clfNameXpath, email),email);
		assertEquals(base.getTextByLocator(webTablePage.clfNameXpath, age),age);
		assertEquals(base.getTextByLocator(webTablePage.clfNameXpath, salary),salary);
		assertEquals(base.getTextByLocator(webTablePage.clfNameXpath, department),department);
		webTablePage.deleteRow();
	}
	
}
