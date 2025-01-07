package com.vamega.pages;

import org.openqa.selenium.WebDriver;

import resources.commonLibs.implementations.ElementControl;

public class BasePage {
	
	WebDriver driver;
	
	public ElementControl elementControl;
	
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		
		elementControl = new ElementControl(driver);
		
	}

}
