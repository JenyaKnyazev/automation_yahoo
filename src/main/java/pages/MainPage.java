package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage{
	@FindBy(xpath="//input[@id='ybar-sbq']")
	public WebElement txt_search_bar;
	
	@FindBy(id="ybar-search")
	public WebElement btn_search;

	@FindBy(xpath="//input[@id='ybarNotificationMenu']/parent::div/parent::div/parent::div[@role='toolbar']//div//div//a[text()='Sign in']")
	public List<WebElement> btn_sign_in;

	@FindBy(id="root_2")
	public WebElement toolbarNews_btn;
}
