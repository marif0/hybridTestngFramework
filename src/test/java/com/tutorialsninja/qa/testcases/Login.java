package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class Login extends Base {
	
	LoginPage loginPage;
	
	public Login() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
	
		driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
		
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.navigateToLoginPage();
		
		//homePage.clickOnMyAccount();
		//loginPage = homePage.selectLoginOption();		
		
		/*driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();*/
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

	/*@Test(priority = 1)
	public void verifyLoginWithValidCredentials() {

		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("validPassword");

		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
	}*/
	
	@Test(priority = 1 , dataProvider = "validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email , String password) {
		
		//LoginPage loginPage = new LoginPage(driver);
		
		AccountPage accountPage = loginPage.login(email, password);
		
		//loginPage.enterEmailAddress(email);
		//loginPage.enterPassword(password);
		//AccountPage accountPage = loginPage.clickOnLoginButton();

		//AccountPage accountPage = new AccountPage(driver);
		
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption(), "Edit Your Account Information option is not displayed.");
		
		
		/*driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());*/
	}
	
	@DataProvider(name = "validCredentialsSupplier")
	public Object[][] supplyTestData() {
		
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {

		//LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		
		//loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		//loginPage.clickOnLoginButton();
		
		//String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarning();
		
		/*driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();*/
		
		//String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		
		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarning().contains(dataProp.getProperty("emailPasswordNoMatchWarning")), "Expected Warning Message is not displayed..");
		
	}
	
	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {

		//LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login(Utilities.generateEmailWithTimeStamp(), prop.getProperty("validPassword"));
		
		//loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//loginPage.enterPassword(prop.getProperty("validPassword"));
		//loginPage.clickOnLoginButton();
		
		//String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarning();
		
		/*driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();*/
		
		//String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		
		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarning().contains( dataProp.getProperty("emailPasswordNoMatchWarning")), "Expected Warning Message is not displayed..");
		
	}
	

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		
		//LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		
		//loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		//loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		//loginPage.clickOnLoginButton();
		
		//String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarning();
		
		/*driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();*/
		
		//String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		
		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarning().contains(dataProp.getProperty("emailPasswordNoMatchWarning")), "Expected Warning Message is not displayed..");
		
	}
	
	@Test(priority = 5)
	public void verifyLoginWithoutEmailAndPassword() {
		
		//LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnLoginButton();
		
		//String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarning();
		
		/*driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();*/
		
		//String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		
		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarning().contains(dataProp.getProperty("emailPasswordNoMatchWarning")), "Expected Warning Message is not displayed..");
		
	}

}
