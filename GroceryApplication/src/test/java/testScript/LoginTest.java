package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage home;
	@Test(priority = 1, description = "User is trying to login with valid credentials.", groups = { "smoke" })
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		home=lp.clickLoginButton();

		// Assertions
		boolean dashBoardValue = lp.verifyWhetherDashboardIsDisplayed();
		Assert.assertTrue(dashBoardValue,Constant.VALIDCREDENTIALERROR );
	}

	@Test(priority = 2, description = "User is trying to login with valid username and invalid password.", retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String userNameValue = ExcelUtility.readStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue).clickLoginButton();

		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.VALIDANDINVALIDERROR );

	}

	@Test(priority = 3, description = "User is trying to login with invalid username and valid password.")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String userNameValue = ExcelUtility.readStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue).clickLoginButton();

		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.INVALIDANDVALIDERROR);

	}

	@Test(priority = 4, description = "User is trying to login with invalid credentials.", groups = { "smoke" },dataProvider="LoginData")
	public void verifyUserLoginWithInvalidCredentials(String userNameValue,String passwordValue) throws IOException {
		//String userNameValue = ExcelUtility.readStringData(3, 0, "LoginPage");
		//String passwordValue = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue).clickLoginButton();

		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.INVALIDCREDENTIALSERROR);

	}

	@DataProvider(name = "LoginData")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { new Object[] { "Admin", "admin22" }, new Object[] { "user1", "admin2" } };
	}

}
