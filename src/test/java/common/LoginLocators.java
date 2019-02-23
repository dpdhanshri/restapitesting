package common;

import org.openqa.selenium.By;

public class LoginLocators extends PopUpCommonHandle {
	protected static By Login = By.xpath("//span[@class='poplogin_main poplogin']");
	protected static By Email = By.xpath("//input[@id='txtLUNm']");
	protected static By pass = By.xpath("//input[@id='txtLPass']");
	protected static By LoginButton = By.xpath("//input[@id='btnlogon']");
}
