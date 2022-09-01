package extensions;



import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Varification extends utils.CommonOps{
    public static void VerifyElementPresents(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed());
        currentTest.pass("verify element is present");
    }
}
