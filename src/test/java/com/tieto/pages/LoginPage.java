package com.tieto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	private  By userLocator = By.id("authUser");
	private  By passLocator = By.id("clearPass");
	private  By languageLocator = By.name("languageChoice");
	private  By loginButton = By.xpath("//button[@type='submit']");
	private By errorLocator = By.xpath("//div[contains(@class,'login-failure')]");
	
	private WebDriver driver;
	
	public LoginPage(WebDriver loginDriver) {
		this.driver = loginDriver;
	}

	public void enterUsername(String username) {
		driver.findElement(userLocator).sendKeys(username);
	}

	public void enterPassword (String password) {
		driver.findElement(passLocator).sendKeys(password);
	}
		
	public void selectDropDown(String dropvalue) {
		Select selectLanguage = new Select(driver.findElement(languageLocator));	
		selectLanguage.selectByVisibleText(dropvalue);
	}
	public void login() {	
		driver.findElement(loginButton).click();
	}
	
	public String getErorMessage() {
		return driver.findElement(errorLocator).getText();
	}
}
