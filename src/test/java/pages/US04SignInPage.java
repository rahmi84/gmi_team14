package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US04SignInPage {
   public US04SignInPage(){
      PageFactory.initElements(Driver.getDriver(),this);
   }

   @FindBy(xpath = "//li[@id='account-menu']")
   public WebElement menuButton;

   @FindBy(xpath= "//span[.='Sign in']")
   public WebElement signIn;

   @FindBy(xpath = "//input[@name='username']")
   public WebElement username;


   @FindBy(xpath = "//input[@name='password']")
   public WebElement password;

   @FindBy(xpath = "//button[@type='submit']")
   public WebElement submitSignInButton;

   @FindBy(xpath = "//span[.='Cancel']")
   public WebElement cancelButton;

   @FindBy(xpath = "//*[@id='account-menu']/a/span")
   public WebElement usernameValidate ;

   @FindBy(xpath = "//*[@id='login-title']/button/span")
   public WebElement logoutButton;

}
