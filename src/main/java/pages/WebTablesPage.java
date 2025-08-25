package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTablesPage extends Page{
	
	By btnAdd = By.id("addNewRecordButton");
	By txtSearchBox = By.id("searchBox");
	By btnDeleteRow = By.xpath("//*[@class = 'rt-td']//span[@title ='Delete']");
	
	//Form add new
	By txtFirstName	 = By.id("firstName");
	By txtLastName	 = By.id("lastName");
	By txtEmail	     = By.id("userEmail");
	By txtAge	     = By.id("age");
	By txtSalary	 = By.id("salary");
	By txtDepartment = By.id("department");	
	By btnSubmit     = By.id("submit");	
	
	public WebTablesPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	
	public void addStaffInfo(String firstName, String lastName, String email, String age, String salary, String department) {
		driver.findElement(btnAdd).click();
		testBase.inputText(txtFirstName, firstName);
		testBase.inputText(txtLastName, lastName);
		testBase.inputText(txtEmail, email);
		testBase.inputText(txtAge, age);
		testBase.inputText(txtSalary, salary);
		testBase.inputText(txtDepartment, department);
		driver.findElement(btnSubmit).click();
	}
	
	public void deleteRow(String rowDelete) {
		testBase.searchOnTable(txtSearchBox, rowDelete);
		driver.findElement(btnDeleteRow).click();
	}
	
}
