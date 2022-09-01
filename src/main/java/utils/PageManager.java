package utils;

import org.openqa.selenium.support.PageFactory;

public class PageManager extends Base{
	public static void initiatPages() {
		mainPage=PageFactory.initElements(driver, pages.MainPage.class);
		resultPage=PageFactory.initElements(driver,pages.ResultPage.class);
		registerPage=PageFactory.initElements(driver,pages.RegisterPage.class);
	}
}
