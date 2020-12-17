package utilities;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.US01$2RegisterPage;

import java.util.List;

public class MyMethods {

    public static void login(){
        US01$2RegisterPage landingPage = new US01$2RegisterPage();

        landingPage.clickAccntMenu();
        landingPage.clickTo("Sign in");
        landingPage.username.sendKeys(ConfigReader.getProperty("EmployeeUsername"));
        landingPage.password.sendKeys(ConfigReader.getProperty("EmployeePassword"));
        landingPage.submit.click();
    }

    public static void getDefaultMessage(String message){
        WebElement element = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'" + message + "')]"));

        String actual = element.getText();
        System.out.println(actual);

        Assert.assertTrue("message is not displayed ",actual.contains(message));

    }


    public static void fillBoxes(String input, String info){
        WebElement element = Driver.getDriver().findElement(By.xpath("//input[@id='" + input + "']"));
        element.clear();
        Driver.waitForVisibility(element,3).sendKeys(info);
        Driver.wait(2);
        System.out.println(info+" Entered to=====>> "+input);

    }


    public static void selectDropDown(String dropdown){
        WebElement element = Driver.getDriver().findElement(By.xpath("//select[@id='" + dropdown + "']"));
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement each : options){
            System.out.println(each.getText());
        }


    }


//end
}
