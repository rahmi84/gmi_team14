package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Random;

public class US08PasswordSegmentPage {
    public US08PasswordSegmentPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    static Random random=new Random();
    Faker faker=new Faker();


    @FindBy(id = "currentPassword")
    public WebElement currentPassword;

    @FindBy(xpath = " //*[@id=\"password-form\"]/div[1]/div")
    public WebElement currentPasswordInvalidFeedback;

    @FindBy(id = "newPassword")
    public WebElement newPassword;

    @FindBy(xpath = " //*[@id=\"password-form\"]/div[2]/div")
    public WebElement newPasswordInvalidFeedback;

    @FindBy(id = "confirmPassword")
    public WebElement confirmPassword;

    @FindBy(xpath = " //div[@class=\"text-danger form-group\"][1]/div")
    public WebElement confirmNewPasswordInvalidFeedback;

    @FindBy(css = "button[type=\"submit\"]")
    public WebElement saveButton;

    @FindBy(css = "ul[id='strengthBar'] li")
    public List<WebElement> passwordStrenghBar;









    //**************************************************************************************
    //Takes String as a parameter of Options " Admin  User  Manager  Customer
    public static void landMeOnPasswordChangeMenu(String role) {

        Driver.loginAll(role);
        WebElement account = Driver.getDriver().findElement(By.cssSelector("li[id='account-menu']"));
        account.click();

        WebElement passWord = Driver.getDriver().findElement(By.cssSelector("div[class=\"dropdown-menu dropdown-menu-right show\"] a:nth-child(2)"));
        passWord.click();

    }


    //Takes String as a parameter of Options " Admin  User  Manager  Customer
    public static void loginwithRole(String role) {
        US04SignInPage us04SignInPage=new US04SignInPage();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.waitForClickablility(us04SignInPage.menuButton, 2);
        Driver.waitForClickablility(us04SignInPage.signIn, 2);
        us04SignInPage.menuButton.click();
        us04SignInPage.signIn.click();
        us04SignInPage.username.sendKeys(ConfigReader.getProperty(role + "Username"));
        us04SignInPage.password.sendKeys(ConfigReader.getProperty(role + "Password"));
        us04SignInPage.submitSignInButton.click();
    }


    //4type
    public String passwordValidWithEverything=faker.internet().password(7,40,true,true,true);
    public String passwordValidWithEverythingBtw4_6=faker.internet().password(4,6,true,true,true);
    public String passwordValidWithEverythingBtw1_3=faker.internet().password(1,3,true,true,true);
    public String passwordValidWithEverythingandspace=" "+faker.internet().password(1,3,true,true,true);
    public String passordempty="";
    // 3 type
    public String passwordValidWithNoDigit=faker.internet().password(7,40,true,true,false);
    public String passwordValidWithNoChar=faker.internet().password(7,40,true,false,true);
    public String passwordValidWithNoUppercase=faker.internet().password(7,40,false,true,true);
    public String getPasswordValidWithNolowercase=faker.internet().password(7,40,false,true,true).toUpperCase();

    // 2 type
    public String passwordValidWithLower_Digit=faker.internet().password(7,40,false,false,true);
    public String passwordValidWithLower_Char=faker.internet().password(7,40,false,true,false);
    public String passwordValidWithLower_Upper=faker.internet().password(7,40,true,false,false);
    public String passwordValidWithUpper_Digit=faker.internet().password(7,40,true,false,true).toUpperCase();
    public String passwordValidWithUpper_Char=faker.internet().password(7,40,true,true,false).toUpperCase();
    public String passwordValidWithChar_Digit4_6=charPassword(2,3)+digitPassword(2,3);
    public String passwordValidWithChar_Digit7_40=charPassword(4,20)+digitPassword(3,20);

    //1 type
    public String passwordwithlowercase7_40=faker.internet().password(7,40,false,false,false);
    public String passwordwithUppercase7_40=faker.internet().password(7,40,false,false,false).toUpperCase();
    public String passwordwithlowercase4_6=faker.internet().password(4,6,false,false,false);
    public String passwordwithUppercase4_6=faker.internet().password(4,6,false,false,false).toUpperCase();
    public String passwordDigit4_6=digitPassword(4,6);
    public String passwordChar4_6=charPassword(4,6);
    public String passwordDigit7_40=digitPassword(7,40);
    public String passwordChar7_40=charPassword(7,40);


    public static String charPassword(int min,int max ){
        int rand=min+random.nextInt(max-min);
        String character="~`\\\"!@#$%^&*()_+-=|}]{[:;'<,>./?";
        String pass="";
        for (int i = 0; i <rand ; i++) {
            int rnd=random.nextInt(32);
            pass+=character.charAt(rnd);
        }
        return pass;
    }

    public static String digitPassword(int min,int max ){
        int rand=min+random.nextInt(max-min);
        String digits="0123456789";
        String pass="";
        for (int i = 0; i <rand ; i++) {
            int rnd=random.nextInt(10);
            pass+=digits.charAt(rnd);
        }
        return pass;
    }



}
