package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.MethodBrowser;

public class ProductDetailsPage extends MethodBrowser {
	
	public ProductDetailsPage() 
	{
		_initPageElements();
	}

	//************ Elements on the web page *************
	
	@FindBy(id="comparison_add_to_cart_button")
	public WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id='comparison_price_row']//td[@class='comparison_baseitem_column']")
	public WebElement priceLabel;
	
	@FindBy(xpath="//*[@id='hlb-subcart']//span/following-sibling::span")
	public WebElement priceCartLabel;
	
	
	@FindBy(className="nav-logo-link")
	public WebElement amazonLogo;	
	
	//****** Methods (Element Actions) ******************
	
	public ProductDetailsPage clickElement(WebElement element)
	{
		_clickElement(element);
		return this;
	}
	
	public ProductDetailsPage implicitWaitWait() 
	{
		_implicitWaitWait();
		return this;
	}
	

}
