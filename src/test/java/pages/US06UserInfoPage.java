package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class US06UserInfoPage {


    public US06UserInfoPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(id = "firstName")
    public WebElement firstNameTxtBox;

    @FindBy(id = "lastName")
    public WebElement lastNameTxtBox;

    @FindBy(id = "email")
    public WebElement emailTxtBox;

    @FindBy(id = "langKey")
    public WebElement langKeyTxtBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id='settings-form']/div[1]/div")
    public WebElement firstNameErrorMessage;

    @FindBy(xpath = "//*[@id='settings-form']/div[2]/div")
    public WebElement lastNameErrorMessage;

    @FindBy(xpath = "//*[@id='settings-form']/div[3]/div")
    public WebElement emailErrorMessage;
    MainEmployeePage mainEmployeePage= new MainEmployeePage();
    MainUserPage mainUserPage=new MainUserPage();
    MainAdminPage mainAdminPage = new MainAdminPage();
    MainCustomerPage mainCustomerPage= new MainCustomerPage();
    public void IamAtUserInfoPage(String user06) {
        switch (user06) {
            case "employee":
                Driver.loginAll("employee");
                Driver.clickWithTimeOut(mainEmployeePage.accountMenu,2);
                Driver.clickWithTimeOut(mainEmployeePage.drpUserInfo,2);
                break;
            case "customer":
                Driver.loginAll("customer");
                Driver.clickWithTimeOut(mainCustomerPage.accountMenu,2);
                Driver.clickWithTimeOut(mainCustomerPage.drpUserInfo,2);

                break;
            case "admin":
                Driver.loginAll("admin");
                Driver.clickWithTimeOut(mainAdminPage.accountMenu,2);
                Driver.clickWithTimeOut(mainAdminPage.drpUserInfo,2);

                break;
            case "user":
                Driver.loginAll("user");
                Driver.clickWithTimeOut(mainUserPage.team14_new_userButton,2);
                Driver.clickWithTimeOut(mainUserPage.UserInfoButton,2);
                break;
        }

    }
}