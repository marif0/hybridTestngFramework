package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailAddressField;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement telephoneField;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyCheckBox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	private WebElement yesSubscribeRadioButton;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement duplicateEmailWarningMessage;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarning;
	
	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarning;
	
	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailAddressWarning;
	
	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telephoneWarning;
	
	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarning;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	//Action methods..
	public void enterFirstName(String firstNameText) {
		firstName.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText) {
		lastName.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailAddressText) {
		emailAddressField.sendKeys(emailAddressText);
	}
	
	public void enterTelephoneNumber(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String passwordText) {
		confirmPasswordField.sendKeys(passwordText);
	}
	
	public void clickOnPrivacyPolicyCheckbox() {
		privacyCheckBox.click();
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void clickOnYesSubscribeRadioButton() {
		yesSubscribeRadioButton.click();
	}
	
	public String retrieveDuplicateEmailWarningMessage() {
		String duplicateEmailAddressWarningMessage = duplicateEmailWarningMessage.getText();
		return duplicateEmailAddressWarningMessage;
	}
	
	public String retrievePrivacyPolicyWarningMessage() {
		String pricacyPolicyWarningText = privacyPolicyWarning.getText();
		return pricacyPolicyWarningText;
	}
	
	public String retrieveFirstNameWarningMessage() {
		String firstNameWarningMessage = firstNameWarning.getText();
		return firstNameWarningMessage;
	}
	
	public String retrieveLastNameWarningMessage() {
		String lastNameWarningMessage = lastNameWarning.getText();
		return lastNameWarningMessage;
	}
	
	public String retrieveEmailAddressWarningMessage() {
		String emailWarningMessage = emailAddressWarning.getText();
		return emailWarningMessage;
	}
	
	public String retrieveTelephoneWarningMessage() {
		String telephoneWarningMessage = telephoneWarning.getText();
		return telephoneWarningMessage;
	}
	
	public String retrievePasswordWarningMessage() {
		String passwordWarningMessage = passwordWarning.getText();
		return passwordWarningMessage;
	}
	
	public AccountSuccessPage registerWithMandatoryField(String firstNameText, String lastNameText, String emailAddressText, String telephoneText, String passwordText) {
		firstName.sendKeys(firstNameText);
		lastName.sendKeys(lastNameText);
		emailAddressField.sendKeys(emailAddressText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(passwordText);
		privacyCheckBox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public AccountSuccessPage registerWithAllField(String firstNameText, String lastNameText, String emailAddressText, String telephoneText, String passwordText) {
		firstName.sendKeys(firstNameText);
		lastName.sendKeys(lastNameText);
		emailAddressField.sendKeys(emailAddressText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(passwordText);
		yesSubscribeRadioButton.click();
		privacyCheckBox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public boolean displayStatusOfWarningMessages(String expectedPrivacyPolicyWarningMessage, String expectedFirstNameWarningMessage, String expectedLastNameWarningMessage, String expectedEmailAddressWarningMessage, String expectedTelephoneWarningMessage, String expectedPasswordWarningMessage) {
		//String actualPricacyPolicyWarningText = privacyPolicyWarning.getText();
		boolean privacyPolicyWarningStatus = privacyPolicyWarning.getText().equals(expectedPrivacyPolicyWarningMessage);
		
		//String actualFirstNameWarningMessage = firstNameWarning.getText();
		boolean firstNameWarningStatus = firstNameWarning.getText().equals(expectedFirstNameWarningMessage);
		
		//String actualLastNameWarningMessage = lastNameWarning.getText();
		boolean lastNameWarningStatus = lastNameWarning.getText().equals(expectedLastNameWarningMessage);
		
		//String actualEmailWarningMessage = emailAddressWarning.getText();
		boolean emailWarningStatus = emailAddressWarning.getText().equals(expectedEmailAddressWarningMessage);
		
		//String actualTelephoneWarningMessage = telephoneWarning.getText();
		boolean telephoneWarningStatus = telephoneWarning.getText().equals(expectedTelephoneWarningMessage);
		
		//String actualPasswordWarningMessage = passwordWarning.getText();
		boolean passwordWarningStatus = passwordWarning.getText().equals(expectedPasswordWarningMessage);
		
		return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus ;
	}
}
