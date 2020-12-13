package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US15CustomerMyAccountPage {

    public US15CustomerMyAccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='account-menu']/a/span")
    public WebElement usernameValidate ;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[3]/span")
    public WebElement singOutButton;

    @FindBy(xpath = "//li[@id='entity-menu']")
    public WebElement myOperationsButton;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement myAccountsButton;

    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement> accountBalance;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> accountType;

    @FindBy(xpath = "(//button[@class='btn btn-success btn-sm'])[1]")
    public WebElement viewTransactionButton;

    @FindBy(xpath = "//tbody/tr/td[5]")
    public List<WebElement> transactions;

    @FindBy(xpath = "(//button[@class='btn btn-success btn-sm'])[2]")
    public WebElement viewTransactionButton2;

}
