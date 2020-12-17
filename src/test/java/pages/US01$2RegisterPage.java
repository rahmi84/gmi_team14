package pages;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class US01$2RegisterPage {

    public US01$2RegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    SoftAssert soft=new SoftAssert();
    Faker faker = new Faker();


    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountMenu;

    @FindBy(xpath="//span[contains(text(),'Register')]")
    public WebElement registerLink;

    @FindBy(xpath = "//form[@id='register-form']")
    public WebElement registrationForm;

    @FindBy(xpath = "//input[@id='ssn']")
    private WebElement ssn;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstName;
    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastname;
    @FindBy(xpath = "//input[@id='address']")
    public WebElement Address;
    @FindBy(xpath = "//input[@id='mobilephone']")
    public WebElement MobilePhoneNumber;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement Username;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement Email;
    @FindBy(xpath = "//input[@id='firstPassword']")
    public WebElement NewPassword;
    @FindBy(xpath = "//input[@id='secondPassword']")
    public WebElement NewPasswordConfirmation;

    @FindBy(xpath = "//li[@class='point']")
    public List<WebElement> colorLevel;

    @FindBy(xpath = "//ul[@id='strengthBar']")
    public WebElement passwordStrength;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement register;
    @FindBy(xpath = "//span[contains(text(),'If you want to ')]")
    public WebElement YouCanTryTheDefaultAcco;
    @FindBy(xpath = "//div[contains(text(),'Your SSN is invalid')]")
    public WebElement invalidSSNMessage;
    @FindBy(xpath = "//div[contains(text(),'Your mobile phone number is invalid')]")
    public WebElement invalidPhoneMessage;





    public void getErrorMessage(String input, String credentials ,String errorMessage){

        WebElement element =   Driver.getDriver().findElement(By.xpath("//input[@id='"+input+"']"));
        element.clear();
        element.sendKeys(credentials);
        //Driver.scrollToElement(register);
        //div[@class='text-danger form-group']
        register.click();
        WebElement invalidMessage =  Driver.getDriver().findElement(By.xpath("//div[.='"+errorMessage+"']"));
        System.out.println("entered ===> "+credentials+ " errorMessage ===> "+ errorMessage );

        soft.assertTrue(invalidMessage.getText().contains(errorMessage),"FAILED!!! Invalid Error Message didn't Displayed.");
    }

    public void setSsn(String ssnNumber){
        Driver.waitForVisibility(ssn,5);
        ssn.sendKeys(ssnNumber);
    }


    public void setFirstName(String firstname){
        Driver.waitForVisibility(firstName,3);
        firstName.sendKeys(firstname);
    }
    public void setLastName(String lastName){
        Driver.waitForVisibility(lastname,3);
        lastname.sendKeys(lastName);
    }
    public void setAddress(String address){
        Driver.waitForVisibility(Address,3);
        Address.sendKeys(address);
    }
    public void setMobilePhoneNumber(String mobilePhoneNumber){
        Driver.waitForVisibility(Username,3);
        MobilePhoneNumber.sendKeys(mobilePhoneNumber);
    }
    public void setUsername(String username){
        Driver.waitForVisibility(Username,3);
        Username.sendKeys(username);
    }
    public void setEmail(String email){
        Driver.waitForVisibility(Email,3);
        Email.sendKeys(email);
    }
    public void setNewPassword(String firstPassword){
        Driver.scrollToElement(YouCanTryTheDefaultAcco);
        Driver.waitForVisibility(NewPassword,3);
        NewPassword.sendKeys(firstPassword);
    }
    public void setNewPasswordConfirmation(String secondPassword){
        Driver.waitForVisibility(NewPasswordConfirmation,3);
        NewPasswordConfirmation.sendKeys(secondPassword);
    }


    public void setColorLevel(){

    }




    public void enterInfo(String input, String info){
        Driver.getDriver().findElement(By.xpath("//input[@id='"+input+"']")).sendKeys(info);

    }

    public void enterValue(Map<String,String> dataTable, String input, String info){

        Driver.getDriver().findElement(By.xpath("//input[@id='"+input+"']"));

        for (String each : dataTable.keySet()){
            dataTable.put(input,info);
        }
    }





    @FindBy(xpath = "//input[contains(@id,'username')]")
    public WebElement username;

    @FindBy(xpath = "//input[contains(@id,'password')]")
    public WebElement password;

    @FindBy(xpath ="//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath =" //*[text()='Cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='modal-content']//span[contains(text(),'Did you forget your password?')]")
    public WebElement alertMessages;

    @FindBy(xpath ="//span[contains(text(),'Operations')]")
    public WebElement myOperations;


    public void clickAccntMenu(){
        accountMenu.click();
    }


    public void clickTo(String button){
        WebElement element=Driver.getDriver().findElement(By.xpath("//span[contains(text(),'"+button+"')]"));
        if(element.isDisplayed()){
            Driver.waitForClickablility(element,3);
        } else{
            element= Driver.getDriver().findElement(By.xpath("(//span[contains(text(),'Sign in')])[3]"));
            Driver.waitForClickablility(element,3);
        }

    }


    public void login(String userName,String passWord){
        Driver.waitAndSendText(username,userName,3);
        Driver.waitAndSendText(password,passWord,3);
        Driver.verifyElementDisplayed(cancelButton);
    }


}



