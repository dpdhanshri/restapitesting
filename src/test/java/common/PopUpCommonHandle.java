package common;
/*if any pop up come this class will make curdsor to click anywhere on page */

import org.openqa.selenium.By;

public class PopUpCommonHandle extends WebDriverUtils
{

	public void popupHandle() 
	{
		click(By.xpath("//div[@class='_pop_close _pop_reg_bg']"));
	}
}

