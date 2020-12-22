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

    @FindBy(xpath = "//dl[@class='jh-entity-details']")
    public List<WebElement> viewCustomerInfoPageElements;

    @FindBy(xpath = "(//span[text()='View'][1])")
    public WebElement viewElement;

    @FindBy(xpath = "//a[@href='/tp-customer/31806/edit']")
    public WebElement edit2ButtonElement;

    @FindBy(xpath = "//div[//@class=\"form-group\"]")
    public List<WebElement> editCustomerInfoPagePopulate;

    @FindBy(id = "save-entity")
    public WebElement saveButtonPopulate;

    @FindBy(xpath = "//span[text()='Edit']")
    public WebElement editButtonElement;


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