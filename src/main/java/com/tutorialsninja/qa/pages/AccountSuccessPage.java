package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement accountSuccessPageHeading;
	
	public AccountSuccessPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String retrieveAccountSuccessPageHeading() {
		
		String accuountSuccessPageHeadingText = accountSuccessPageHeading.getText();
		return accuountSuccessPageHeadingText;
	}

}
