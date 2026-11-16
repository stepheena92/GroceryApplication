package testScript;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageDeliveryBoyTest extends Base{
	HomePage hp;
	ManageDeliveryBoyPage mdp;
	@Test(description="User is trying to add new delivery boy")
	public void verifyWhetherUserIsAbleToAddNewDeliveryBoy() throws IOException {
		
		String userNameValue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		
		//click manage deliveryboy more info link
		mdp=hp.clickManageDeliveryBoyMoreInfo();
		
		//click new button in List delivery boy page
		mdp.clickNewListDeliveryBoy();
		
		//Enter Delivery Boy Informations
		RandomDataUtility rdu=new RandomDataUtility();
		String name=rdu.generateRandomFullName();
		String email=rdu.generateRandomEmail();
		String phoneNumber=rdu.generateRandomPhoneNumber();
		String address=rdu.generateRandomAddress();
		String userName=rdu.generateRandomUsername();
		String password=rdu.generateRandomPassword();
		
		mdp.enterNameOnNameField(name).enterEmailOnEmailField(email).enterPhoneNumberOnPhoneNumberField(phoneNumber).enterAddressOnAddressField(address).enterUserNameonUserNameField(userName).enterPasswordOnPasswordField(password).scrollPage().clickSaveButton();
		
		//verify with Assertions
		String actual=mdp.verifyAddDeliveryBoyAlertIsDisplayed();
		String expected="×\nAlert!\nDelivery Boy Details Created Successfully";
		Assert.assertEquals(actual, expected,Constant.NEWDELIVERYBOYERROR);
	}

}
