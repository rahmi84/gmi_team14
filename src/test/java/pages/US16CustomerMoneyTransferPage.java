package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US16CustomerMoneyTransferPage {

    public US16CustomerMoneyTransferPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//select[@id='fromAccountId']")
    public WebElement fromDropDown;

    @FindBy(xpath = "//select[@id='toAccountId']")
    public WebElement toDropDown;

    @FindBy(xpath = "//input[@name='balance']")
    public WebElement balanceBox;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionBox;

    @FindBy(xpath = "//button[@id='make-transfer']")
    public WebElement makeTransferButton;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement fieldRequiredMessage;




}
