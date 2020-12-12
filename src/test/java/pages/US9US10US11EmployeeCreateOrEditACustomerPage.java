package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US9US10US11EmployeeCreateOrEditACustomerPage {
    public US9US10US11EmployeeCreateOrEditACustomerPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //a[@class="dropdown-item"]
    @FindBy(xpath = "//span[text()=\"Register\"]")
    public WebElement registerCustomerButton;
    @FindBy(xpath = "//a[@href='/tp-customer']")
    public WebElement manageCustomerButton;
    @FindBy(id = "jh-create-entity")
    public WebElement createANewCustomerButton;
    @FindBy(xpath = "//input[@id=\"search-ssn\"]")
    public WebElement ssnBox;
    @FindBy(xpath = "//input[@name=\"firstName\"]")
    public WebElement firstNameBox;
    @FindBy(xpath = "//button[@class=\"btn btn-secondary\"]")
    public WebElement searchButton;
    @FindBy(xpath = "//input[@name=\"lastName\"]")
    public WebElement lastNameBox;
    @FindBy(xpath = "//input[@name=\"middleInitial\"]")
    public WebElement middleInitialBox;
    @FindBy(xpath = "//input[@name=\"email\"]")
    public WebElement emailBox;
    @FindBy(xpath = "//input[@name=\"mobilePhoneNumber\"]")
    public WebElement mobilePhoneNumberBox;
    @FindBy(xpath = "//input[@name=\"phoneNumber\"]")
    public WebElement phoneNumberBox;
    @FindBy(xpath = "//input[@name=\"zipCode\"]")
    public WebElement zipCodeBox;
    @FindBy(xpath = "//input[@name=\"address\"]")
    public WebElement addressBox;
    @FindBy(xpath = "//input[@name=\"city\"]")
    public WebElement cityBox;
    @FindBy(xpath = "//input[@name=\"createDate\"]")
    public WebElement createDateBox;
    @FindBy(xpath = "//select[@name=\"country.id\"]")
    public WebElement countrySelectBox;
    @FindBy(xpath = "//input[@name=\"state\"]")
    public WebElement stateBox;
    @FindBy(xpath = "//select[@name=\"user.id\"]")
    public WebElement userSelectBox;
    @FindBy(xpath = "id=\"tp-customer-account\"")
    public WebElement accountsBox;
    @FindBy(xpath = "//input[@name=\"zelleEnrolled\"]")
    public WebElement zelleBox;
    @FindBy(xpath = "//button[@id=\"save-entity\"]")
    public WebElement saveBox;
}

