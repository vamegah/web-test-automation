package com.vamega.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePage {
	
	@CacheLookup //store the element in memory to improve performance
	@FindBy(xpath = "//input[@name='uid']")
	private WebElement userId;
	
	@CacheLookup
	@FindBy(xpath = "//input[@name='password']")
	private WebElement userPassword;
	
	@CacheLookup
	@FindBy(xpath = "//input[@name='btnLogin']")
	private WebElement loginButton;
	
	@CacheLookup
	@FindBy(xpath = "//input[@name='btnReset']")
	private WebElement resetButton;

	@CacheLookup
	@FindBy(xpath = "//label[@id='message23']")
	private WebElement userIdErrorLabel;
	
	
	public LoginPageObject(WebDriver driver) {
		
		super(driver);
		
		// page factor allows for dynamic loading of the page elements
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String username, String password) {
		
		elementControl.setText(userId, username);
		
		elementControl.setText(userPassword, password);
		
		elementControl.clickElement(loginButton);
		
	}
	
	
}
