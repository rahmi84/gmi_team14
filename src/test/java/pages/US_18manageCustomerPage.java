package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class US_18manageCustomerPage {

    public US_18manageCustomerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//th[@class='hand']")
    public List<WebElement> customerInformationList;

    @FindBy(xpath = "(//span[text()='View'][1])")
    public WebElement viewElement;


    @FindBy(xpath = "//dl[@class='jh-entity-details']")
    public List<WebElement> viewCustomerInfolist;


    @FindBy(xpath = "//a[@href=\"/tp-customer/33854/edit?page=1&sort=id,asc\"]")
    public WebElement editButtonElement;

    @FindBy(xpath = "//form[@class=\"av-valid\"]")
    public List<WebElement> editCustomerInfoList;

    @FindBy(id = "save-entity")
    public WebElement saveButtonPopulate;



    @FindBy(xpath = " (//span[text()='Delete'][1])")
    public WebElement deleteButtonElement;

    @FindBy(id = "jhi-confirm-delete-tPCustomer")
    public WebElement deleteConfimationElement;

    @FindBy(css = " [class=\"Toastify__toast-container Toastify__toast-container--top-left toastify-container\"]")
    public WebElement deleteVerifyElement;





    @FindBy(xpath = "//span[text()='First Name']")
    public WebElement firstnameElement;

    @FindBy(xpath = "//span[text()='Last Name']")
    public WebElement lastnameElement;

    @FindBy(xpath = "//span[text()='Middle Initial']")
    public WebElement middleInitialElement;

    @FindBy(xpath = "//span[text()='Email']")
    public WebElement EmailElement;

    @FindBy(xpath = "//span[text()='Mobile Phone Number']")
    public WebElement mobilenumberElement;

    @FindBy(xpath = "//span[text()='Phone Number']")
    public WebElement phoneNumberElement;

    @FindBy(xpath = "//span[text()='Address']")
    public WebElement addressElement;

    @FindBy(xpath = "//span[text()='Create Date']")
    public WebElement CreateDateElement;


    /////////////////////////////////////////////////////////////////////////
    public static void AdminLogin() {
        US04SignInPage signIn = new US04SignInPage();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.clickWithTimeOut(signIn.menuButton, 4);
        Driver.clickWithTimeOut(signIn.signIn, 4);

        Driver.wait(1);
        signIn.username.sendKeys("team11admin");
        Driver.wait(1);
        signIn.password.sendKeys("Team11admin");
        Driver.wait(1);
        signIn.submitSignInButton.submit();
        Driver.wait(1);

    }

}