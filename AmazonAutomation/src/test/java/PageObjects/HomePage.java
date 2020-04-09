package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dataProviders.ConfigFileReader;
import framework.MethodBrowser;

public class HomePage extends MethodBrowser {
	
	public HomePage() 
	{
		_initBrowser();
		_initPageElements();
	}

	//************ Elements on the web page *************
	
	@FindBy(id="twotabsearchtextbox")
	public WebElement searchBox;
	
	@FindBy(className="nav-input")
	public WebElement searchBtn;

	@FindBy(css="div.s-result-list.s-search-results.sg-row")
	public WebElement resultList;
	
	@FindBy(id="nav-link-accountList")
	public WebElement accountList;
	
	
	//****** Methods (Element Actions) ******************
	
	public HomePage goTo() 
	{
		_goTo(ConfigFileReader.getJsonString("webUrl"));
		return this;
	}
	
	
	public HomePage enterText(WebElement element, String Text) 
	{
		_enterText(element, Text);
		return this;
	}
	
	public HomePage clickElement(WebElement element)
	{
		_clickElement(element);
		return this;
	}
	
	public HomePage quitDriver() 
	{
		_quit();
		return this;
	}
	
	public HomePage implicitWaitWait() 
	{
		_implicitWaitWait();
		return this;
	}
	
	public HomePage clickFirstProduct(WebElement element, String childXpath) 
	{
		_clickFirstProduct(element, childXpath);
		return this;
	}
	
	public HomePage explicitWait(WebElement element) 
	{
		_explicitWait(element);
		return this;
	}

}
