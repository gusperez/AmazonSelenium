package framework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MethodBrowser extends GetTitlePage{
	
	private static WebDriver driver;
	private WebDriverWait wait;
	
	public void _initBrowser()
	{
		driver = _setUpDriver("Chrome");
	}
	
	protected void _initPageElements()
	{
		PageFactory.initElements(driver, this);
	}
	protected WebDriver _setUpDriver(String browserName)
	{
		
		switch (browserName) {
		
		case "Chrome": 
			System.setProperty("webdriver.chrome.driver", "/Users/gustavo/ChromeDriver/chromedriver80");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		break;
		
		case "Gecko": 
			System.setProperty("webdriver.gecko.driver", "/Users/gustavo/ChromeDriver/geckodriver");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		break;
		
		default :
		    break;
		}
	
		return driver;
		
	}
	
	protected void _getTitlePage() 
	{
		System.out.println("Title of the webpage: "+driver.getTitle());
	}

	protected void _goTo(String Url) 
	{
		driver.get(Url);	
		_getTitlePage();
	}
	
	protected void _quit() 
	{
		driver.quit();
	}
	
	protected String _getBrowserTitle()
	{
		return driver.getTitle();
	}
	
	protected void _clickElement(WebElement element)
	{
		element.click();
	} 

   
	protected void _implicitWaitWait() 
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	protected void _enterText(WebElement element, String Text) 
	{
		element.sendKeys(Text);
	}
	
	protected void _explicitWait(WebElement element) 
	{
		wait = new WebDriverWait (driver, 10);
		//wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
	protected void _clickFirstProduct(WebElement element, String childXpath) 
	{
		List<WebElement> result = element.findElements(By.xpath(childXpath));
		
		for (WebElement ele:result) {
				ele.click();
				break;
		}
	}

}
