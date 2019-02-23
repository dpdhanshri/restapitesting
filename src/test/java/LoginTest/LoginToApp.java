package LoginTest;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.LoginLocators;
import common.ReadData;
import common.WebDriverUtils;

public class LoginToApp extends LoginLocators
{
	String URL = "https://www.firstcry.com/";
	String invalidUsername = "1234567890";
	String invalidPassword = "password12345";

	@BeforeClass
	public void setup() throws MalformedURLException
	{
		WebDriverUtils.loadBrowser();
		pause(1000);
		WebDriverUtils.openApplication(URL);
		pause(1000);
		popupHandle();	
	}

	public void login(String userName, String password)
	{
		click(LoginLocators.Login);
		pause(2000);
		typeText(LoginLocators.Email,userName);
		typeText(LoginLocators.pass,password);
		pause(1000);
		//mouseMove();
		click(LoginLocators.LoginButton);

	}
	@Test(priority =0)
	public void validlogin()
	{
		ReadData.readCredentials();
		pause(1000);
		login(ReadData.MyUser,ReadData.pass);
		pause(1000);
	}

	//*@Test
	public void invalidLogin(String invalidUsername, String invalidPassword)
	{
		login(invalidUsername,invalidPassword);
		Assert.assertEquals(getInvalidLoginMessage(), "Please enter valid Email ID/Mobile number");

	}

	//@AfterClass
	public void tearDown() 
	{
		closeBrowser();
	}
}
