
package common;

import java.net.MalformedURLException;
import java.net.URL;
//import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//declaration of all webdriver common methods
public class WebDriverUtils
{
	static WebDriver driver;
	public static void loadBrowser() throws MalformedURLException
	{
		//download IE driver exe file kept at one locatiopn like below
	//if you want grid execution then comment below section
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			
		/*Here code start for grid execution; for this comment 'new ChromeDRIVER' line and create 
		remote driver object also delcared variables URL & nodeURL
		 */
		/*String nodeURL = "https://localhost:4444/wd/hub";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
		DesiredCapabilities cap = DesiredCapabilities.chrome(); //use whichever browser you want
		cap.setBrowserName("Chrome");
		cap.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL(nodeURL),cap);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
*/
	}

	public static void openApplication(String URL)
	{
		driver.get(URL);
	}
	public static WebElement getElement(By locator)
	{
		long timeout = 0;
		final WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
		return driver.findElement(locator);
	}


	public static void click(By locator)
	{
		long timeout = 0;
		final WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));

		getElement(locator).click();

	}

	public static String getText(By locator) {
		return getElement(locator).getText();
	}
	public void mouseMove() {
		Actions act = new Actions(driver);
		act.moveByOffset(500, 700);
	}

	protected void pause(int i) {
		// TODO Auto-generated method stub

	}  
	protected String getInvalidLoginMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void typeText(By locator, String text) {
		getElement(locator).sendKeys(text);
	}
	public void closeBrowser()
	{
		driver.close();
		driver.quit();
	}


}
