package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
	
	WebDriver driver;
	
	@FindBy(linkText = "Edit your account information")
	private WebElement editYourAccountInformation; 

	public AccountPage(WebDriver driver) {
		
		this.driver = driver ;
	}
	
	//action method
	public boolean getDisplayStatusOfEditYourAccountInformationOption() {
		boolean displayStatus = editYourAccountInformation.isDisplayed();
		return displayStatus;
	}
}
