package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;


public class HomeTest extends Base {
	HomePage hp;
	
	@Test(description="User is trying to logout successfully")
	public void verifyWhetherUserIsAbleToSuccessfullyLogOut() throws IOException {
		
		String userNameValue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		
		
		hp.clickAdminButton();
		lp=hp.clickLogOutButton();
		
		//assertEquals()
		String actual=lp.verifyLoginTextIsDisplayed();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.LOGOUTERROR);
		
		
	}

}
