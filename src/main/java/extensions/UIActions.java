package extensions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UIActions extends utils.CommonOps{
    public static void Click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        currentTest.info("click");
    }

    public static void SendKeys(WebElement element,String text){
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        element.clear();
        element.sendKeys(text);
        currentTest.info("enter text");
    }
}
