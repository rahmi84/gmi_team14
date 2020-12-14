package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_005LoginPage {

    public US_005LoginPage(){
    PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//*[@id=\"login-page\"]/div/form/div[2]/div[1]/div[1]/div")
    public WebElement errorMessage;

    @FindBy(xpath = "(//span)[21]")
    public WebElement cancelButton;

    @FindBy(xpath = "//span[.='Did you forget your password?']")
    public WebElement messageButton;

    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement resetPasswordAlert;

    @FindBy(xpath = "//span[.='Register a new account']")
    public  WebElement registerNewButton;

}