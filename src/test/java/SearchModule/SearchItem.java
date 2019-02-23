package SearchModule;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.LoginLocators;
import common.ReadData;
import common.SearchLocators;
import common.WebDriverUtils;

public class SearchItem extends SearchLocators

{
	public void search(String product) throws InterruptedException
	{
		Thread.sleep(10000);
		click(SearchLocators.Search);
		System.out.println("hi");
		typeText(SearchLocators.Search,product);
		//pause(1000);
		Thread.sleep(10000);
		click(SearchLocators.SearchIcon);
		Thread.sleep(10000);
		click(SearchLocators.sortOption);
		Thread.sleep(5000);
		click(SearchLocators.Mychoice);
		pause(1000);
	}
	@Test(priority =0)
	public void MyProduct() throws InterruptedException
	{
		ReadData.readItem();
		pause(1000);
		search(ReadData.Item1);
		Thread.sleep(100000);
	}
}
