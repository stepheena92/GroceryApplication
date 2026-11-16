package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base{
	HomePage hp;
	AdminUsersPage au;
	@Test(description="User is trying to add new Admin user.")
	public void verifyWhetherUserIsAbleToAddNewAdminUser() throws IOException {
		
		String userNameValue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		//click admin user more info link
		
		au=hp.clickAdminUserMoreInfo();
		//click new in admin user page
		
		au.clickNewAdminUserButton();
		//read username and password from excelsheet:AdminPage
		RandomDataUtility rdu=new RandomDataUtility();
		String userNameValue1=rdu.generateRandomUsername();
		String passwordValue1=rdu.generateRandomPassword();
		//Add new user
		au.enterUsernameOnAdminUser(userNameValue1).enterPasswordOnAdminUser(passwordValue1).selectUserTypeInAdminUser().clickSaveButton();
		
		//verify using Assert
		String actual=au.verifyAddUserAlertIsDisplayed();
		String expected="×\nAlert!\nUser Created Successfully";
			
		Assert.assertEquals(actual, expected,"User is not created");
		
		
		
	}
	@Test(description="User is trying to search newly added Admin user")
	public void verifyWhetherUserIsAbleToSearchTheNewlyAddedAdminUser() throws IOException {
	
		String userNameValue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		
		//click admin user more info link
		
		au=hp.clickAdminUserMoreInfo();
		
		//search user
		au.clickBlueSearchButton();
		String userNameValue1=ExcelUtility.readStringData(0, 0, "AdminUser");
		au.enterUserNameInSearchAdminUsers(userNameValue1).selectUserTypeinSearchAdminUsers().clickRedSearchButton();
		//verify 
		String actual=au.verifySearchedUsernameIsAvailable();
		String expected="stephy.anto";
		Assert.assertEquals(actual, expected,"User not found");
				
	}
	

}
/*Testcase:
 * verifywhetheruserisabletoaddnewadminuser
 * verifywhetheruserisabletosearchthenewlyaddedadminuser
*/
