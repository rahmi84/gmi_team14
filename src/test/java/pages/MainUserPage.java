package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainUserPage {

    public  MainUserPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText ="Home")
    public WebElement HomeButton;

    @FindBy(xpath="//a[@href ='/loan']")
    public WebElement LoansButton;

    @FindBy(xpath ="(//a[@href ='/about'])[1]")
    public WebElement AboutUsButton;

    @FindBy(xpath ="(//a[@href ='/services'])[1]")
    public WebElement ServicesButton;

    @FindBy(xpath ="(//a[@href ='/blog'])[1])")
    public WebElement BlogButton;

    @FindBy(xpath ="(//a[@href ='/about'])[2]")
    public  WebElement AboutButton;

    @FindBy(xpath ="(//a[@href='/contact'])[1]")
    public WebElement ContactButton;

    //Dropdown
    @FindBy(xpath ="(//a[@href='#'])[1]")
    public WebElement MyOperationsButton;

    @FindBy(xpath ="//a[@href='/tp-customer']")
    public WebElement ManageCustomersButton;

//    @FindBy(xpath ="//a[@href='/tp-account']")
//    public WebElement ManageAccountsButton;

    //Dropdown
    @FindBy(xpath ="(//a[@href='#'])[2]")
    public WebElement team14_new_userButton;

//    @FindBy(xpath ="//a[@href='/account/settings']")
//    public WebElement UserInfoButton;

//    @FindBy(xpath = "//a[@href='/account/password']")
//    public WebElement PasswordButton;

//    @FindBy(xpath ="//a[@href='/logout']")
//    public WebElement SignOutButton;
}