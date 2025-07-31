package tests;

import org.testng.annotations.BeforeTest;

import common.TestBase;

public class TestCase {
	public TestBase base = new TestBase();
	@BeforeTest
	public void openWeb() {
		base.openBrowser();
	}

}
