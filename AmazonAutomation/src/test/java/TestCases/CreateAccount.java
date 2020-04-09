package TestCases;

import org.testng.annotations.Test;

import PageObjects.CreateAccountPage;
import PageObjects.HomePage;
import PageObjects.ProductDetailsPage;
import PageObjects.SignInPage;
import dataProviders.ConfigFileReader;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CreateAccount {
	
	HomePage homePage;
	ProductDetailsPage productDetailsPage;
	SignInPage signInPage;
	CreateAccountPage createAccountPage;

  @BeforeTest
  public void beforeTest() {
	  
	  homePage = new HomePage();
	  productDetailsPage = new ProductDetailsPage();
	  signInPage = new SignInPage();
	  createAccountPage = new CreateAccountPage();
  }
  
  @Test
  public void test() {
	  
	  homePage
	  .goTo()
	  .implicitWaitWait()
	  .enterText(homePage.searchBox, ConfigFileReader.getJsonString("product"))
	  .explicitWait(homePage.searchBox)
	  .clickElement(homePage.searchBtn)
	  .implicitWaitWait()
	  .clickFirstProduct(homePage.resultList, ConfigFileReader.getJsonString("childXpath_Image"))
	  .implicitWaitWait();
	  
	  //Storing the product price displayed on Product Details
	  String priceOnDetails = productDetailsPage.priceLabel.getText().replace("\n", ".");
	  
	  productDetailsPage
	  .clickElement(productDetailsPage.addToCartBtn)
	  .implicitWaitWait();
	  
	  //Storing the product price displayed on the Cart
	  String priceOnCart = productDetailsPage.priceCartLabel.getText();
	  
	  try {
		  Assert.assertEquals(priceOnDetails,priceOnCart);
		  System.out.println("Price on Product Details and Cart are matching");
		  System.out.println("Price on Product Details = "+priceOnDetails);
		  System.out.println("Price on Cart = "+ priceOnCart);
	  }
	  
	  catch (AssertionError e){
		  System.out.println("Both prices are not matching");
		  System.out.println("Price on Product Details = "+priceOnDetails);
		  System.out.println("Price on Cart = "+ priceOnCart);
	  }
	  
	  productDetailsPage
	  .clickElement(productDetailsPage.amazonLogo);
	  
	  homePage
	  .clickElement(homePage.accountList);
	  
	  signInPage
	  .implicitWaitWait()
	  .clickElement(signInPage.createAcctBtn);
	  
	  createAccountPage
	  .implicitWaitWait()
	  .enterText(createAccountPage.customerNameBox, ConfigFileReader.getJsonString("name"))
	  .enterText(createAccountPage.emailBox, ConfigFileReader.getJsonString("email"))
	  .enterText(createAccountPage.passwordBox, ConfigFileReader.getJsonString("password"))
	  .enterText(createAccountPage.reEnterPasswordBox, ConfigFileReader.getJsonString("re_enterpwd"));
	  
	  try {
		  Assert.assertEquals(createAccountPage.createAcctLabel.getText(),ConfigFileReader.getJsonString("textToValidate"));
		  System.out.println("Text is present");
	  }
	  
	  catch (AssertionError e){
		  System.out.println("Text is NOT present");
	  }
	  
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
