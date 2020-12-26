package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainCustomerPage {
    public MainCustomerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//li[@id='entity-menu']")
    public WebElement myOperationsDropdown;

    @FindBy(xpath = "//*[@id='entity-menu']/div/a[1]")
    public WebElement drpMyAccounts;

    @FindBy(xpath = "//*[@id='entity-menu']/div/a[2]")
    public WebElement drpTransferMoney;

    @FindBy(id= "account-menu")
    public WebElement accountMenu;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[1]")
    public WebElement drpUserInfo;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[2]")
    public WebElement drpPassword;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[3]")
    public WebElement drpSignOut;

}
