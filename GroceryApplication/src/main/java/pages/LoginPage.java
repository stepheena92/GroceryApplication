package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
public WebDriver driver;
WaitUtility wu=new WaitUtility();
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//input[@placeholder='Username']")WebElement userName;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement password;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signIn;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashBoard;
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement loginPageText;
	
	public LoginPage enterUsernameOnUsernameField(String userNameValue) {
		userName.sendKeys(userNameValue);
		return this;
	}
	public LoginPage enterPasswordOnPasswordField(String passwordValue) {
		password.sendKeys(passwordValue);
		return this;
	}
	public HomePage clickLoginButton() {
		wu.waitUntilElementToBeClickable(driver, signIn);
		signIn.click();
		return new HomePage(driver);
	}
	public boolean verifyWhetherDashboardIsDisplayed() {
		return dashBoard.isDisplayed();
	}
	public String verifyLoginTextIsDisplayed() {
		return loginPageText.getText();
	}

}
