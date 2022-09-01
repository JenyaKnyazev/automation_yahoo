package execute;

import extensions.UIActions;
import extensions.Varification;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.MainPage;
import utils.Excel;

import java.util.List;


@Listeners(utils.Listeners.class)
public class Main extends utils.CommonOps{
	@BeforeClass
	public void init(){
		InitBrowser();
	}


	@Test
	public void registerTest(){
		UIActions.Click(mainPage.btn_sign_in.get(0));
		UIActions.Click(registerPage.btn_create_account);
		UIActions.SendKeys(registerPage.firstName,"john");
		UIActions.SendKeys(registerPage.lastName,"dou");
		UIActions.SendKeys(registerPage.email,"jaofjiapsfmdsakpf");
		UIActions.SendKeys(registerPage.password,"9684964Aghba");
		UIActions.SendKeys(registerPage.birthYear,"1980");
		UIActions.Click(registerPage.btn_submit);
		Varification.VerifyElementPresents(registerPage.afterSubmit);
	}
	@Test
	public void searchTest() throws InterruptedException {
		UIActions.SendKeys(mainPage.txt_search_bar, "laptop");
		UIActions.Click(mainPage.btn_search);
		Thread.sleep(2000);
		String value=resultPage.searchResults.getText().split(" ")[1];
		System.out.println(value);
		List<String> dataExcel= Excel.readExelFile("searchData.xlsx");
		for(int i=0;i<dataExcel.size();i++){
			UIActions.SendKeys(resultPage.searchBarResults, dataExcel.get(i));
			UIActions.Click(resultPage.btn_search_abr_results);
			value=resultPage.searchResults.getText().split(" ")[1];
			System.out.println(value);
		}
	}
	@Test
	public void clickTestNews(){
		UIActions.Click(mainPage.toolbarNews_btn);
		for(int i=1;i<9;i++){
			UIActions.Click(resultPage.newsToolbarLinks.get(i));
		}
	}
	@AfterMethod
	public void afterEveryTest(){
		driver.get("https:\\www.yahoo.com");
	}
	@AfterClass
	public void terminate(){
		extent.flush();
		driver.quit();
	}
}
