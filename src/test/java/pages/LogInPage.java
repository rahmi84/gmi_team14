package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LogInPage {


    @FindBy(id = "account-menu")
    public WebElement accountMenu;


    public LogInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}