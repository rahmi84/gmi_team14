package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@id=\"header-tabs\"]/li[1]/a/span/span")
    public WebElement clickHome;

    @FindBy(xpath = "//*[@id=\"header-tabs\"]/li[2]/a")
    public WebElement clickLoan;

    @FindBy(xpath = "//*[@id=\"header-tabs\"]/li[3]/a")
    public  WebElement clikcAboutUs;

    @FindBy(xpath = "//*[@id=\"header-tabs\"]/li[4]/a")
    public WebElement buttonSignin;

    @FindBy(xpath = "//*[@id=\"header-tabs\"]/li[5]/a")
    public WebElement clikcBlog;

    @FindBy(xpath = "//*[@id=\"header-tabs\"]/li[6]/a/span")
    public List<WebElement> clikcAbout;

    @FindBy(xpath = "//*[@id=\"header-tabs\"]/li[6]/a/span")
    public List<WebElement> clikcContact;

    @FindBy(id = "account-menu")
    public WebElement userMenu;

    @FindBy(xpath = "//a[@href  = '/account/register']")
    public WebElement userRegistrationButton;

}
