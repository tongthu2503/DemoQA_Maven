package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.TestBase;

public class TestCase {
	public TestBase base = new TestBase();
	@BeforeMethod
	public void openWeb() {
		base.openBrowser();
	}
	//@AfterMethod
	public void closeBrowser() {
		base.webDriver.quit();
	}
}
