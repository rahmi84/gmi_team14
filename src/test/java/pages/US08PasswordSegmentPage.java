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

    @FindBy(xpath = " //*[@id=\"password-form\"]/div[]/div")
    public WebElement confirmNewPasswordInvalidFeedback;

    @FindBy(css = "button[type=\"submit\"]")
    public WebElement saveButton;

    @FindBy(css = "ul[id='strengthBar'] li")
    public List<WebElement> passwordStrenghBar;









   //**************************************************************************************
    //Takes String as a parameter of Options " Admin  User  Manager  Customer
    public static void landMeOnPasswordChangeMenu(String role) {

        signInAsrole(role);
        WebElement account = Driver.getDriver().findElement(By.cssSelector("li[id='account-menu']"));
        account.click();

        WebElement passWord = Driver.getDriver().findElement(By.cssSelector("div[class=\"dropdown-menu dropdown-menu-right show\"] a:nth-child(2)"));
        passWord.click();

    }


    //Takes String as a parameter of Options " Admin  User  Manager  Customer
    public static void signInAsrole(String role) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        WebElement userphoto = Driver.getDriver().findElement(By.cssSelector("li[id='account-menu']"));
        userphoto.click();
        WebElement signin = Driver.getDriver().findElement(By.cssSelector("a[id='login-item']"));
        signin.click();
        WebElement username = Driver.getDriver().findElement(By.id("username"));
        username.sendKeys(ConfigReader.getProperty(role + "Username"));
        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys(ConfigReader.getProperty(role + "Password"));
        WebElement signIn = Driver.getDriver().findElement(By.cssSelector(" button[type=\"submit\"]"));
        signIn.click();
    }


    //4type
    public String passwordValidWithEverything=faker.internet().password(7,40,true,true,true);
    // 3 type
    public String passwordValidWithNoDigit=faker.internet().password(7,40,true,true,false);
    public String passwordValidWithNoChar=faker.internet().password(7,40,true,false,true);
    public String passwordValidWithNoUppercase=faker.internet().password(7,40,false,true,true);
    public String getPasswordValidWithNolowercase=faker.internet().password(7,40,false,true,true).toUpperCase();

    // 2 type
    public String passwordValidWithLower_Digit=faker.internet().password(7,40,false,false,true);
    public String passwordValidWithLower_Char=faker.internet().password(7,40,false,true,false);
    public String passwordValidWithLower_Upper=faker.internet().password(7,40,true,false,false);
    public String passwordValidWithUpper_Digit=faker.internet().password(7,40,true,false,false).toUpperCase();
    public String passwordValidWithUpper_Char=faker.internet().password(7,40,true,true,false).toUpperCase();
    public String passwordValidWithChar_Digit=charPassword(20)+digitPassword(20);

    //1 type
    public String passwordwithlowercase=faker.internet().password(4,40,false,false,false);
    public String passwordwithUppercase=faker.internet().password(4,40,false,false,false).toUpperCase();
    public String passwordDigit=digitPassword(40);
    public String passwordChar=charPassword(40);


    public static String charPassword(int size ){
        int rand=7+random.nextInt(size-7);
        String character="~`\\\"!@#$%^&*()_+-=|}]{[:;'<,>./?";
        String pass="";
        for (int i = 0; i <rand ; i++) {
            int rnd=random.nextInt(32);
            pass+=character.charAt(rnd);
        }
        return pass;
    }

    public static String digitPassword(int size){
        int rand=7+random.nextInt(size-7);
        String digits="0123456789";
        String pass="";
        for (int i = 0; i <rand ; i++) {
            int rnd=random.nextInt(10);
            pass+=digits.charAt(rnd);
        }
        return pass;
    }



}
