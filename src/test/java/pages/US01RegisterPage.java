package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US01RegisterPage {

    public US01RegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement ssnBox;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//input[@id='address']")
    public WebElement adressBox;

    @FindBy(xpath = "//input[@id='mobilephone']")
    public WebElement mobilePhoneNumberBox;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='firstPassword']")
    public WebElement newPasswordBox;

    @FindBy(xpath = "//input[@id='secondPassword']")
    public WebElement newPasswordConfirmationBox;

    @FindBy(xpath = "//button[@id='register-submit']")
    public WebElement registerButton;








}
