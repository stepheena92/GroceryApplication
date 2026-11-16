package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement admin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")WebElement logOut;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminUserMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'and@class='small-box-footer']")WebElement manageDeliveryBoyMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'and @class='small-box-footer']")WebElement categoryMoreInfo;
	
	public HomePage clickAdminButton() {
		
		admin.click();
		return this;
		
	}
	
	public LoginPage clickLogOutButton() {
		
		logOut.click();
		return new LoginPage(driver);
		
	}
	public AdminUsersPage clickAdminUserMoreInfo() {
		
		adminUserMoreInfo.click();
		return new AdminUsersPage(driver);
		
	}
	public ManageDeliveryBoyPage clickManageDeliveryBoyMoreInfo() {
		
		manageDeliveryBoyMoreInfo.click();
		return new ManageDeliveryBoyPage(driver);
	}
	public ManageCategoryPage clickCategoryMoreInfo() {
		
		categoryMoreInfo.click();
		return new ManageCategoryPage(driver);
	}

}

/*
 * create webelement for more info and a method to click moreinfo.
 * 
 */
