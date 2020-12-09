package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US12EmployeeManageCustomersPage {

    public US12EmployeeManageCustomersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='First Name']")
    public WebElement firstName;

    @FindBy(xpath = "//*[text()='Last Name']")
    public WebElement lastName;

    @FindBy(xpath = "//*[text()='Middle Initial']")
    public WebElement middleInitial;

    @FindBy(xpath = "//*[text()='Email']")
    public WebElement email;

    @FindBy(xpath = "//*[text()='Mobile Phone Number']")
    public WebElement mobilePhoneNumber;

    @FindBy(xpath = "//*[text()='Phone Number']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//*[text()='Address']")
    public WebElement address;

    @FindBy(xpath = "//*[text()='Create Date']")
    public WebElement createDate;

    @FindBy(xpath = "//tbody/tr[1]/td[10]/div[1]/a[1]")
    public WebElement view;

    @FindBy(xpath = "//tbody/tr[1]/td[10]/div[1]/a[2]")
    public WebElement edit;

    @FindBy(xpath = "//tbody/tr[1]/td[10]/div[1]/a[3]")
    public WebElement delete;




}
