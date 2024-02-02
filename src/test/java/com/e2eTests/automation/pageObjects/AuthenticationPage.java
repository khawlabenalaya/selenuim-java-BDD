package com.e2eTests.automation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.e2eTests.automation.utils.ConfigFileReader;
public class AuthenticationPage {




	private ConfigFileReader configFileReader = new ConfigFileReader();

	/*@FindBy*/
	final static String USERNAME_ID = "user-name";
	final static String PASSWORD_ID = "password";
	final static String BUTTON_lOGIN_ID = "login-button";
	final static String ERROR_XPATH ="//div[@class='error-message-container error']";
	

	/*@FindBy*/
	
	@FindBy(how = How.ID, using = USERNAME_ID)
	public static WebElement username;
	@FindBy(how = How.ID, using = PASSWORD_ID)
	public static WebElement password;
	@FindBy(how = How.ID, using = BUTTON_lOGIN_ID)
	public static WebElement buttonLogin;
	@FindBy(how = How.XPATH, using = ERROR_XPATH)
	public static WebElement ErrorMessage;
	
	

	/*Methods*/
	
	
	public void fillUserName() {

		String username1 = configFileReader.getProperties("username");
		username.sendKeys(username1);
		
	}
	public void fillPassword() {
		String password1 = configFileReader.getProperties("password");
		password.sendKeys(password1);

	}
	public void fillPasswordAndUserNameIncorect() {
		String username2 = configFileReader.getProperties("usernameIncorrect");
		username.sendKeys(username2);
		String password2 = configFileReader.getProperties("passwordIncorrect");
		password.sendKeys(password2);

	}
	
	public void clickLoginButton() {
		buttonLogin.click();
	}

}
