package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class US13EmployeeManageAccountsPage {
    public US13EmployeeManageAccountsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

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

    @FindBy(xpath = "  //select[@id='tp-account-employee']")
    public WebElement employeeClickElement;

   @FindBy(css = "[class='Toastify__toast-body']")
   public WebElement saveSuccessMessage;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButtonElement;

    @FindBy(css = "input.is-invalid.form-control")
    public WebElement blankBalanceErrorElement;


    //////////////////////////////MY METHODS//////////////////////////////////////////////////

    public void selectAccounType(String accountType) {
        Select select = new Select(accountTypeElement);
        select.selectByValue(accountType);
    }

    public void selectAccountStatusType(String accountStatusType) {
        Select select = new Select(accountStatusTypeElement);
        select.selectByValue(accountStatusType);
    }

    /**
     * jsGetText method use java script command to capture success message
     * @param element
     * @param
     * @return
     */
    public static String JsGetText(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        return jse.executeScript("return arguments[0].innerText", element).toString();
//        return jse.executeScript("return arguments[0].innerHtml", element).toString();
    }
    }








