package utils;

import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonOps extends Base {
	public static ExtentTest currentTest=extent.createTest("name");
	public static void InitBrowser() {
		driver=chromeDriver();
		htmlReporter=new ExtentSparkReporter("ExtentReport/extentReport" +dtf.format(localDate)+".html");
		extent.attachReporter(htmlReporter);
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver,10);
		driver.get("https:\\www.yahoo.com");
		PageManager.initiatPages();

	}
	public static WebDriver chromeDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
