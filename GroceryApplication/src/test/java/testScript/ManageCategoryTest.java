package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base{
	HomePage hp;
	ManageCategoryPage mcp;
	@Test(description="User is trying to add new category")
	public void verifyWhetherUserIsAbleToAddNewCategory() throws IOException {
		
		String userNameValue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		//click category more info link
		mcp=hp.clickCategoryMoreInfo();
		
		//click new in categorypage
		
		mcp.clickNewCategoryButton();
		
		//enter category info
		String categoryName=ExcelUtility.readStringData(0, 0, "Category");
		mcp.enterCategoryOnAddCategory(categoryName).selectGroupNameOnAddCategory().chooseFileOnAddCategory().clickSaveButtonOnAddCategory();
		
		//verify using Assert
		String actual=mcp.verifyAddUserAlertIsDisplayed();
		String expected="�\nAlert!\nCategory Created Successfully";				
		Assert.assertEquals(actual, expected,Constant.NEWCATEGORYERROR);
	}
	@Test(description="User is trying to search newly added category")
	public void verifyWhetherUserIsAbleToSearchCategory() throws IOException {
		
		String userNameValue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		//click category more info link
		
		mcp=hp.clickCategoryMoreInfo();
		//check search button on add category
		mcp.clickBlueSearchButton();
		String categoryName=ExcelUtility.readStringData(0, 0, "Category");
		mcp.enterCategoryInSearchCategory(categoryName).clickRedSearchButton();
		
		//verify 
		String actual=mcp.verifySearchedCategoryIsAvailable();
		String expected="Cooking oils";
		Assert.assertEquals(actual, expected,Constant.SEARCHCATEGORYERROR);
	}

}
