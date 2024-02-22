package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class Register extends Base {
	
	RegisterPage registerPage ;
	AccountSuccessPage accountSuccessPage ;
	
	public Register() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		
		homePage.navigateToRegisterPage();
		
		//homePage.clickOnMyAccount();
		//registerPage = homePage.selectRegisterOption();
		
		/*driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();*/
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFeilds() {

		//RegisterPage registerPage = new RegisterPage(driver);
		accountSuccessPage = registerPage.registerWithMandatoryField(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("mobileNumber"), prop.getProperty("validPassword"));
		
		/*registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("mobileNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.clickOnPrivacyPolicyCheckbox();
		accountSuccessPage = registerPage.clickOnContinueButton();*/
		
		/*driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataProp.getProperty("mobileNumber"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualSuccessHeading = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();*/
		
		//AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		
		//String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();
		
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success Page is not displayed..");

	}

	@Test(priority = 2)
	public void verifyRegisteringAccountByProvindingAllFields() {

		//RegisterPage registerPage = new RegisterPage(driver);
		
		accountSuccessPage = registerPage.registerWithAllField(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("mobileNumber"), prop.getProperty("validPassword"));
		
		/*registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("mobileNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.clickOnYesSubscribeRadioButton();
		registerPage.clickOnPrivacyPolicyCheckbox();
		accountSuccessPage = registerPage.clickOnContinueButton();*/
		
		//AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		//String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();
		
		
		/*driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataProp.getProperty("mobileNumber"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualSuccessHeading = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();*/

		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success Page is not displayed..");

	}

	
	@Test(priority = 3)
	public void verifyRegisteringAccountWithExistingEmailAddress() {

		//RegisterPage registerPage = new RegisterPage(driver);
		
		registerPage.registerWithAllField(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("validEmail"), dataProp.getProperty("mobileNumber"), prop.getProperty("validPassword"));

		
		/*registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(prop.getProperty("validEmail"));
		registerPage.enterTelephoneNumber(dataProp.getProperty("mobileNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.clickOnYesSubscribeRadioButton();
		registerPage.clickOnPrivacyPolicyCheckbox();
		registerPage.clickOnContinueButton();*/
		
		//String actualSuccessHeading = registerPage.retrieveDuplicateEmailWarningMessage();				
		
		/*driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataProp.getProperty("mobileNumber"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualSuccessHeading = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();*/

		Assert.assertEquals(registerPage.retrieveDuplicateEmailWarningMessage(), dataProp.getProperty("duplicateEmailWarning"), "Expected Warning Message is not displayed..");

	}
	
	@Test(priority = 4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {

		//RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickOnContinueButton();
		
		Assert.assertTrue(registerPage.displayStatusOfWarningMessages(dataProp.getProperty("privacyPolicyWarning"), dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"), dataProp.getProperty("emailWarning"), dataProp.getProperty("telephoneWarning"), dataProp.getProperty("passwordWarning")), "status warning message is not displayed..");
		
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();

		//String actualPrivacyPolicyWarning = registerPage.retrievePrivacyPolicyWarningMessage();
		//String actualPrivacyPolicyWarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		//Assert.assertEquals(registerPage.retrievePrivacyPolicyWarningMessage(), dataProp.getProperty("privacyPolicyWarning"), "Policy Warning Message is not displayed..");

		//String firstNameWarningText = registerPage.retrieveFirstNameWarningMessage();
		//String firstNameWarningText = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
		//Assert.assertEquals(registerPage.retrieveFirstNameWarningMessage(), dataProp.getProperty("firstNameWarning"), "first name warning message is not displayed..");
		
		//String lastNameWarningText = registerPage.retrieveLastNameWarningMessage();
		//String lastNameWarningText = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
		//Assert.assertEquals(registerPage.retrieveLastNameWarningMessage(), dataProp.getProperty("lastNameWarning"), "first name warning message is not displayed..");
		
		//String emailWarningText = registerPage.retrieveEmailAddressWarningMessage();
		//String emailWarningText = driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
		//Assert.assertEquals(registerPage.retrieveEmailAddressWarningMessage(), dataProp.getProperty("emailWarning"), "email warning message is not displayed..");
		
		//String telephoneWarningText = registerPage.retrieveTelephoneWarningMessage();
		//String telephoneWarningText = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
		//Assert.assertEquals(registerPage.retrieveTelephoneWarningMessage(), dataProp.getProperty("telephoneWarning"), "telephone warning message is not displayed..");
		
		//String passwordWarningText = registerPage.retrievePasswordWarningMessage();
		//String passwordWarningText = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();
		//Assert.assertEquals(registerPage.retrievePasswordWarningMessage(), dataProp.getProperty("passwordWarning"), "password warning message is not displayed..");
				
	}
}
