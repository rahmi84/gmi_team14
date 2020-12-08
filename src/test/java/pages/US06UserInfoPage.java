package pages;

<<<<<<< HEAD
public class US06UserInfoPage {
=======

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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


>>>>>>> master
}
