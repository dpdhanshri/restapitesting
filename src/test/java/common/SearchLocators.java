package common;
import org.openqa.selenium.By;

public class SearchLocators extends PopUpCommonHandle
{
	protected static By Search = By.xpath("//input[@class ='input-text']");
	protected static By SearchIcon = By.xpath("//img[@class ='search-button']");
	protected static By sortOption = By.xpath("//a[.='Price']");
	protected static By Mychoice = By.xpath("//a[@title = 'Pampers Active Baby Diapers Extra Large - 32 Pieces']");
	
}
