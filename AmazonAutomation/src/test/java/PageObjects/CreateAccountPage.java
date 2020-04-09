package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.MethodBrowser;

public class CreateAccountPage extends MethodBrowser {
	
	public CreateAccountPage() 
	{
		_initPageElements();
	}

	//************ Elements on the web page *************
	
	@FindBy(id="ap_customer_name")
	public WebElement customerNameBox;
	
	@FindBy(id="ap_email")
	public WebElement emailBox;
	
	@FindBy(id="ap_password")
	public WebElement passwordBox;
	
	@FindBy(id="ap_password_check")
	public WebElement reEnterPasswordBox;
	
	@FindBy(className="a-spacing-small")
	public WebElement createAcctLabel;
	
	
	//****** Methods (Element Actions) ******************
	
	public CreateAccountPage enterText(WebElement element, String Text) 
	{
		_enterText(element, Text);
		return this;
	}
	
	public CreateAccountPage implicitWaitWait() 
	{
		_implicitWaitWait();
		return this;
	}


}
