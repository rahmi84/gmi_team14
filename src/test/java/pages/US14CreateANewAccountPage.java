package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US14CreateANewAccountPage {
    public US14CreateANewAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@name='description']")
    public WebElement description;
    @FindBy(xpath = "//input[@name='balance']")
    public WebElement balance;
    @FindBy(xpath = "//input[@name='accountType']")
    public WebElement accountType;
    @FindBy(xpath = "//input[@name='accountStatusType']")
    public WebElement accountStatusType;
    @FindBy(xpath = "//input[@name='createDate']")
    public WebElement createDate;
    @FindBy(xpath = "//input[@name='closedDate']")
    public WebElement closedDate;
    @FindBy(xpath = "//input[@name='employee.id']")
    public WebElement employee;
    @FindBy(xpath = "//span[contains(text(),'Save')]")
    public WebElement save;
    @FindBy(xpath = "//span[contains(text(),'Back')]")
    public WebElement back;
    @FindBy(id = "entity-menu")
    public WebElement myOperationsDropdown;
    @FindBy(xpath = "//*[@id='entity-menu']/div/a[2]")
    public WebElement drpManageAccounts;
    @FindBy(xpath = "//*[@id=\'jh-create-entity\']/span")
    public WebElement createANewAccount;
    @FindBy(xpath = "//td[text()='translation-not-found[gmiBankBackendApp.tPAccount.created]']")
    public WebElement accountCreated;
    @FindBy(xpath = "//span[contains(text(),'Sign Out')]")
    public WebElement drpSignOut;
    @FindBy(xpath = "//span[contains(text(),'Tech14 Tech')]")
    public WebElement employeemenu;
    @FindBy(linkText = "51181")
    public WebElement idOfCustomer;







}
