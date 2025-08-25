package pages;

import org.openqa.selenium.WebDriver;

public class ThanksForSubmitting extends Page {

	public String fieldValueXpath	= "//td[text()= '{@param}']/following-sibling::td" ;
	
	public ThanksForSubmitting(WebDriver dr) {
		super(dr);
	}

}
