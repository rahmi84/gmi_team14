package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;
import utilities.Driver;

public class US13EmployeeManageAccountsPage {
    public US13EmployeeManageAccountsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[text()='My Operations']")
    public WebElement manageOperationElement;

    @FindBy(xpath = "//span[text()='Manage Accounts']")
    public WebElement manageAccountElement;

    @FindBy(xpath = "//span[text()='Create a new Account']")
    public WebElement EmployeeCreateaNewAccountElemenet;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement descriptionElement;

    @FindBy(css = "input.is-invalid.form-control")
    public WebElement descriptionInvalidElement;

    @FindBy(xpath = "//input[@name='balance']")
    public WebElement balanceElement;

    @FindBy(id = "tp-account-accountType")
    public WebElement accountTypeElement;

    @FindBy(xpath = " //select[@name='accountStatusType']")
    public WebElement accountStatusTypeElement;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButtonElement;

    @FindBy(css = "input.is-invalid.form-control")
    public WebElement blankBalanceErrorElement;

    @FindBy(css = "[data-icon='home']")
    public WebElement headerHomeButtonElement;

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    /////my methods
    public void selectAccounType(String accountType) {
        Select select = new Select(accountTypeElement);
        select.selectByValue(accountType);
    }

    public void selectAccountStatusType(String accountStatusType) {
        Select select = new Select(accountStatusTypeElement);
        select.selectByValue(accountStatusType);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////


    //Takes String as a parameter of Options " Admin  User  Manager  Customer

    public static String getAlert(){
        return Driver.getDriver().switchTo().alert().getText();
    }


    //Takes String as a parameter of Options " Admin  User  Manager  Customer
    public static void signInAsrole(String role) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        WebElement userphoto = Driver.getDriver().findElement(By.cssSelector("li[id='account-menu']"));
        userphoto.click();
        WebElement signin = Driver.getDriver().findElement(By.cssSelector("a[id='login-item']"));
        signin.click();
        WebElement username = Driver.getDriver().findElement(By.id("username"));
        username.sendKeys( "Tech14Employee");
        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("Tech14Employee!");
        WebElement signIn = Driver.getDriver().findElement(By.cssSelector(" button[type=\"submit\"]"));
        signIn.click();
    }



}
