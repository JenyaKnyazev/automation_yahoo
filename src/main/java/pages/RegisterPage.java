package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {
    @FindBy(id="createacc")
    public WebElement btn_create_account;
    @FindBy(id="usernamereg-firstName")
    public WebElement firstName;
    @FindBy(id="usernamereg-lastName")
    public WebElement lastName;
    @FindBy(id="usernamereg-userId")
    public WebElement email;
    @FindBy(id="usernamereg-password")
    public WebElement password;
    @FindBy(id="usernamereg-birthYear")
    public WebElement birthYear;
    @FindBy(id="reg-submit-button")
    public WebElement btn_submit;

    @FindBy(xpath="//h2[@class=\"challenge-heading\"]")
    public WebElement afterSubmit;
}
