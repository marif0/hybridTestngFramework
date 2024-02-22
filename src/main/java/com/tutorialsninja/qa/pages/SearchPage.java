package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath = "//h2[normalize-space()='Products meeting the search criteria']")
	private WebElement noProductMessage;
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayStstusOfHPValidProduct() {
		boolean displayStatus = validHPProduct.isDisplayed();
		return displayStatus;
	}
	
	public String retrieveNoProductMessageText() {
		String noProductMessageText = noProductMessage.getText();
		return noProductMessageText;
	}

}
