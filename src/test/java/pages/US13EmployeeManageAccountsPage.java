package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US13EmployeeManageAccountsPage {
    public  US13EmployeeManageAccountsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//span[text()='My Operations']")
    public WebElement manageOperationElement;

    @FindBy(id = "//span[text()='Manage Accounts']")
    public WebElement manageAccountElement;

    @FindBy(xpath = "//span[text()='Create a new Account']")
    public WebElement EmployeeCreateaNewAccountElemenet;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement descriptionElement;

    @FindBy(xpath = "//input[@name='balance']")
    public WebElement balanceElement;

    @FindBy(id = "tp-account-accountType")
    public WebElement accountTypeElement;

    @FindBy(id = " //select[@name='accountStatusType']")
    public WebElement accountStatusTypeElement;

    @FindBy(xpath = "(//input[@placeholder='YYYY-MM-DD HH:mm'])[1]")
    public WebElement createDateElement;

    @FindBy(xpath = "//input[@name='closedDate']")
    public WebElement closedDateElement;

    @FindBy(xpath = "//select[@name='employee.id']")
    public WebElement employeeDrpodownElement;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButtonElement;

    @FindBy(css = "input.is-invalid.form-control")
    public WebElement blankBalanceErrorElement;








}

