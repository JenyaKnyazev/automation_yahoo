package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage {
    @FindBy(xpath="//img[@class='s-img bdr-4']")
    public WebElement iphoneIMG;
    @FindBy(xpath="//span[contains(text(),'search results') and contains(text(),'About')]")
    public WebElement searchResults;
    @FindBy(xpath="//input[@id='yschsp']")
    public WebElement searchBarResults;
    @FindBy(xpath="//input[@type='submit']")
    public WebElement btn_search_abr_results;
    @FindBy(xpath="//ul[@role='presentation']/li")
    public List<WebElement> newsToolbarLinks;
}
