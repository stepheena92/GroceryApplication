package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.PageUtility;

public class AdminUsersPage {
	
	public WebDriver driver;
	PageUtility pu=new PageUtility();
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newAdminUser;
	@FindBy(xpath="//input[@id='username']")WebElement newUserName;
	@FindBy(xpath="//input[@id='password']")WebElement newPassWord;
	@FindBy(xpath="//select[@id='user_type']")WebElement userType;
	@FindBy(xpath="//button[@name='Create']")WebElement save;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement blueSearch;
	@FindBy(xpath="//input[@id='un']")WebElement searchUserName;
	@FindBy(xpath="//select[@id='ut']")WebElement searchUserType;
	@FindBy(xpath="//button[@name='Search']")WebElement redSearch;
	//@FindBy(xpath="//i[@class='icon fas fa-check']")WebElement alertMsg;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successText;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")WebElement searchedUsername;
	

	
	public AdminUsersPage clickNewAdminUserButton() {
		
		newAdminUser.click();
		return this;
	}
	public AdminUsersPage enterUsernameOnAdminUser(String userNameValue1) {
		
		newUserName.sendKeys(userNameValue1);
		return this;
	}
	public AdminUsersPage enterPasswordOnAdminUser(String passwordValue1) {
		
		newPassWord.sendKeys(passwordValue1);
		return this;
	}
	public AdminUsersPage selectUserTypeInAdminUser() {
		pu.selectDropdownWithVisibleText(userType, "Admin");
		return this;
		
	}
	public AdminUsersPage clickSaveButton() {
		
		save.click();
		return this;
	}
	public AdminUsersPage clickBlueSearchButton() {
		
		blueSearch.click();
		return this;
		
	}
	public AdminUsersPage enterUserNameInSearchAdminUsers(String userNameValue1) {
		
		searchUserName.sendKeys(userNameValue1);
		return this;
	}
	public AdminUsersPage selectUserTypeinSearchAdminUsers() {
		pu.selectDropdownWithVisibleText(searchUserType, "Admin");
		return this;
		/*Select obj=new Select(searchUserType);
		obj.selectByVisibleText("Admin");*/
	}
	public AdminUsersPage clickRedSearchButton() {
		
		redSearch.click();
		return this;
		
	}
	public String verifyAddUserAlertIsDisplayed() {
		
		return successText.getText();
		
	}
	public String verifySearchedUsernameIsAvailable() {
		return searchedUsername.getText();
	}
	
}
/*create webelements for new,username,password,usertype,save.
 * 
 *excel sheet:adminuser
 * 
*/