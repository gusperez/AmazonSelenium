package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.MethodBrowser;

public class SignInPage extends MethodBrowser {
	
	public SignInPage() 
	{
		_initPageElements();
	}

	//************ Elements on the web page *************
	
	@FindBy(id="createAccountSubmit")
	public WebElement createAcctBtn;
	
	
	//****** Methods (Element Actions) ******************
	
	public SignInPage clickElement(WebElement element)
	{
		_clickElement(element);
		return this;
	}
	
	public SignInPage implicitWaitWait() 
	{
		_implicitWaitWait();
		return this;
	}

}
