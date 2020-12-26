package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US04SignInPage {
    public US04SignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement menuButton;
    @FindBy(xpath= "//span[.='Sign in']")
    public WebElement signIn;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitSignInButton;
    @FindBy(xpath = "//span[.='Cancel']")
    public WebElement cancelButton;
    @FindBy(xpath = "//*[@id='account-menu']/a/span")
    public WebElement usernameValidate ;
    @FindBy(xpath = "//*[@id='login-title']/button/span")
    public WebElement logoutButton;
    @FindBy(xpath = "//*[@id='account-menu']/div/a[3]/span")
    public WebElement SignOutMenu;
    @FindBy(xpath = "//*[text()=' Please check your credentials and try again.']")
    public WebElement errorMessage;
}