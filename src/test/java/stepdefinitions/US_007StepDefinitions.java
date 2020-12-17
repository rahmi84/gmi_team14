package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.US06UserInfoPage;
import utilities.Driver;

import java.util.List;

public class US_007StepDefinitions {

    US06UserInfoPage us06UserInfoPage= new US06UserInfoPage();

    @When("Click the current email box")
    public void click_the_current_email_box() {
    us06UserInfoPage.emailTxtBox.click();
    }

    @When("Send key {string}")
    public void send_key(String string) {
        us06UserInfoPage.emailTxtBox.clear();
        us06UserInfoPage.emailTxtBox.sendKeys(string);
    }

    @When("Click save button to see error message")
    public void click_save_button_to_see_error_message() {
      us06UserInfoPage.saveButton.click();
    }

    @Then("Verify the error message")
    public void verify_the_error_message() {
        Driver.waitForVisibility(us06UserInfoPage.emailErrorMessage,2);
        Assert.assertTrue(us06UserInfoPage.emailErrorMessage.getText(),true);
    }

    @When("Click the language box")
    public void click_the_language_box() {
     us06UserInfoPage.langKeyTxtBox.click();
    }

    @When("Select from dropdown menu Turkish and English options")
    public void select_from_dropdown_menu_Turkish_and_English_options() {
        Select lang= new Select(us06UserInfoPage.langKeyTxtBox);
        lang.selectByIndex(0);
        lang.selectByIndex(1);

    }

    @Then("Verify  languages which is in dropdown menu")
    public void verify_languages_which_is_in_dropdown_menu() {
        Select lang= new Select(us06UserInfoPage.langKeyTxtBox);
        List<WebElement> languages = lang.getOptions();
        String one= languages.get(0).getText();
        String two= languages.get(1).getText();
        String totl=one+","+two;
        String expected="English,Türkçe";
        Assert.assertEquals(expected,totl);
    }
    @When("Click on firstname box")
    public void click_on_firstname_box() {
    us06UserInfoPage.firstNameTxtBox.click();
    }

    @When("Send invalid firstname for {string}")
    public void send_invalid_firstname_for(String string) {
    us06UserInfoPage.firstNameTxtBox.clear();
    us06UserInfoPage.firstNameTxtBox.sendKeys(string);
    }

    @When("Click on lastname box")
    public void click_on_lastname_box() {
    us06UserInfoPage.lastNameTxtBox.click();
    }

    @When("Send invalid lastname for {string}")
    public void send_invalid_lastname_for(String string) {
    us06UserInfoPage.lastNameTxtBox.clear();
    us06UserInfoPage.lastNameTxtBox.sendKeys(string);
    }

    @When("click save botton to see error message")
    public void click_save_botton_to_see_error_message() {
    us06UserInfoPage.saveButton.click();

    }

    @Then("Verify the error message for lastname and firstname")
    public void verify_the_error_message_for_lastname_and_firstname() {
        Assert.assertTrue(us06UserInfoPage.firstNameErrorMessage.isDisplayed());
        Assert.assertTrue(us06UserInfoPage.lastNameErrorMessage.isDisplayed());
    }



}
