package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class Search extends Base {
	
	SearchPage searchPage ;
	
	HomePage homePage;
	
	public Search() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
		
		homePage = new HomePage(driver);
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		
		//HomePage homePage = new HomePage(driver);
		
		homePage.searchForProduct(dataProp.getProperty("validProduct"));
		
		//homePage.enterProductIntoSearchBoxField(dataProp.getProperty("validProduct"));
		//searchPage = homePage.clickSearchButton();
		
		/*driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(dataProp.getProperty("validProduct"));
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();*/	
		//SearchPage searchPage = new SearchPage(driver);
		
		Assert.assertTrue(searchPage.displayStstusOfHPValidProduct(), "Valid product  HP is not displayed in the search results.");
		
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}
	
	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {
		
		//HomePage homePage = new HomePage(driver);
		
		homePage.searchForProduct(dataProp.getProperty("invalidProduct"));
		
		//homePage.enterProductIntoSearchBoxField(dataProp.getProperty("invalidProduct"));
		//searchPage =homePage.clickSearchButton();
		
		//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(dataProp.getProperty("invalidProduct"));
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		//SearchPage searchPage = new SearchPage(driver);
		
		//String actualSearchMessage = searchPage.retrieveNoProductMessageText();
		
		//String actualSearchMessage = driver.findElement(By.xpath("//h2[normalize-space()='Products meeting the search criteria']")).getText();
		
		Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProp.getProperty("noProductTextInSearchResults"), "No Product in search results is not displayed");
	}
	
	@Test(priority = 3)
	public void verifySearchWithoutAnyProduct() {
		
		//HomePage homePage = new HomePage(driver);
		searchPage = homePage.clickSearchButton();
		
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();	
		//SearchPage searchPage = new SearchPage(driver);
		
		//String actualSearchMessage = searchPage.retrieveNoProductMessageText();
		
		//String actualSearchMessage = driver.findElement(By.xpath("//h2[normalize-space()='Products meeting the search criteria']")).getText();
		
		Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProp.getProperty("noProductTextInSearchResults"), "No Product in search results is not displayed");
	}
}
