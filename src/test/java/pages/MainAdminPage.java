package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainAdminPage {
    public MainAdminPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id= "account-menu")
    public WebElement accountMenu;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[1]")
    public WebElement drpUserInfo;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[2]")
    public WebElement drpPassword;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[3]")
    public WebElement drpSignOut;

    @FindBy(id= "entity-menu")
    public WebElement myOperations;

    @FindBy(xpath= "//*[@id='entity-menu']/div/a[1]")
    public WebElement drpMyAccounts;

    @FindBy(xpath= "//*[@id='entity-menu']/div/a[2]")
    public WebElement drpTransferMoney;

    @FindBy(id= "admin-menu")
    public WebElement administration;

    @FindBy(xpath= "//*[@id='admin-menu']/div/a[1]")
    public WebElement userManagement;

    @FindBy(xpath= "//*[@id='admin-menu']/div/a[2]")
    public WebElement metrics;

    @FindBy(xpath= "//*[@id='admin-menu']/div/a[3]")
    public WebElement health;

    @FindBy(xpath= "//*[@id='admin-menu']/div/a[4]")
    public WebElement configuration;

    @FindBy(xpath= "//*[@id='admin-menu']/div/a[5]")
    public WebElement audits;

    @FindBy(xpath= "//*[@id='admin-menu']/div/a[6]")
    public WebElement logs;
}
