package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage {
	
	public WebDriver driver;
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newListDeliveryBoy;
	@FindBy(xpath="//input[@id='name']")WebElement name;
	@FindBy(xpath="//input[@id='email']")WebElement email;
	@FindBy(xpath="//input[@id='phone']")WebElement phoneNumber;
	@FindBy(xpath="//textarea[@id='address']")WebElement address;
	@FindBy(xpath="//input[@id='username']")WebElement userName;
	@FindBy(xpath="//input[@id='password']")WebElement password;
	@FindBy(xpath="//button[@type='submit']")WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successText;
	
	
	public ManageDeliveryBoyPage clickNewListDeliveryBoy() {
		
		newListDeliveryBoy.click();
		return this;
		
	}
	public ManageDeliveryBoyPage enterNameOnNameField(String nameValue) {
		
		name.sendKeys(nameValue);
		return this;
	}
	public ManageDeliveryBoyPage enterEmailOnEmailField(String emailValue) {
		
		email.sendKeys(emailValue);
		return this;
		
	}
	public ManageDeliveryBoyPage enterPhoneNumberOnPhoneNumberField(String phoneNumberValue) {
		
		phoneNumber.sendKeys(phoneNumberValue);
		return this;
	}
	public ManageDeliveryBoyPage enterAddressOnAddressField(String addressValue) {
		
		address.sendKeys(addressValue);
		return this;
	}
	public ManageDeliveryBoyPage enterUserNameonUserNameField(String userNameValue) {
		
		userName.sendKeys(userNameValue);
		return this;
	}
	public ManageDeliveryBoyPage enterPasswordOnPasswordField(String passwordValue) {
		
		password.sendKeys(passwordValue);
		return this;
	}
	public ManageDeliveryBoyPage clickSaveButton() {
		
		saveButton.click();
		return this;
	}
	public ManageDeliveryBoyPage scrollPage() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)","");
		return this;
		
	}
	public String verifyAddDeliveryBoyAlertIsDisplayed() {
		
		return successText.getText();
	}
}
