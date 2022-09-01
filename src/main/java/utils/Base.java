package utils;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Base {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	
	
	//extent report
	protected static ExtentReports extent=new ExtentReports();
	protected static ExtentSparkReporter htmlReporter;
	protected static DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYYY/MM/DD");
	protected static LocalDate localDate=LocalDate.now();
	
	//pages
	protected static pages.MainPage mainPage;
	protected static pages.ResultPage resultPage;
	protected static pages.RegisterPage registerPage;

}
