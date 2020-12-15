package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US06UserInfoPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class US_006StepDefinitions {
  US06UserInfoPage us06UserInfoPage=new US06UserInfoPage();

    @Given("I am at the user info page")
    public void i_am_at_the_user_info_page() {
    us06UserInfoPage.IamAtUserInfoPage("customer");
    }

    @When("Click the current firstname box")
    public void click_the_current_firstname_box() {
        us06UserInfoPage.firstNameTxtBox.click();
    }


    @When("Get the firstname from firstname box")
    public void get_the_firstname_from_firstname_box() {
     String currentFirstName= us06UserInfoPage.firstNameTxtBox.getText();
    }

    @When("Click the current lastname box")
    public void click_the_current_lastname_box() {
      us06UserInfoPage.lastNameTxtBox.click();
    }

    @When("Get the lastname from lastname box")
    public void get_the_lastname_from_lastname_box() {
        String currentLastName= us06UserInfoPage.lastNameTxtBox.getText();
    }

    @When("Click current email box")
     public void click_current_email_box() {
    us06UserInfoPage.emailTxtBox.click();
  }

    @And("Get the email from email box")
    public void get_the_email_from_email_box() {
        String currentEmail= us06UserInfoPage.emailTxtBox.getText();
    }


    @When("Get the current language from language box")
    public void get_the_current_language_from_language_box() {
        String currentLanguage= us06UserInfoPage.langKeyTxtBox.getText();
    }
    @Then("Verify all boxes are not null")
    public void verify_all_boxes_are_not_null() {
    Assert.assertTrue(us06UserInfoPage.saveButton.isEnabled());
    }

    @When("Click the language dropdown menu")
    public void click_the_language_dropdown_menu() {
    us06UserInfoPage.langKeyTxtBox.click();
    }

    @When("Get the languages")
    public void get_the_languages() {
        Select lang= new Select(us06UserInfoPage.langKeyTxtBox);
        List<WebElement> languages = lang.getOptions();
        String langList= languages.toString();
        System.out.println(languages);
    }


    @Then("Verify the languages which is in dropdown menu")
    public void verify_the_languages_which_is_in_dropdown_menu() {
        Select lang= new Select(us06UserInfoPage.langKeyTxtBox);
        List<WebElement> languages = lang.getOptions();
       String one= languages.get(0).getText();
       String two= languages.get(1).getText();
       String totl=one+","+two;
       String expected="English,Türkçe";
        Assert.assertEquals(expected,totl);
    }


    @When("Click on firstname box on userinfo page")
    public void click_on_firstname_box_on_userinfo_page() {
        us06UserInfoPage.firstNameTxtBox.click();
    }

    @When("Check if firstname is editable")
    public void check_if_firstname_is_editable() {
      us06UserInfoPage.firstNameTxtBox.isEnabled();
    }

    @When("Send valid firstname")
    public void send_valid_firstname() {
    us06UserInfoPage.firstNameTxtBox.clear();
      Driver.wait(2);
    us06UserInfoPage.firstNameTxtBox.sendKeys("teamgmi");
    }

    @When("Click on save button")
    public void click_on_save_button() {
    us06UserInfoPage.saveButton.click();
    }

    @Then("Verify the firstname changed")
    public void verify_the_firstname_changed() {
      Driver.doubleClick(us06UserInfoPage.firstNameTxtBox);
    Assert.assertEquals("teamgmi",us06UserInfoPage.firstNameTxtBox.getText());

    }
    @When("Click on lastname box on userinfo page")
    public void click_on_lastname_box_on_userinfo_page() {
    us06UserInfoPage.lastNameTxtBox.click();
    }

    @When("Check if lastname is editable")
    public void check_if_lastname_is_editable() {
    us06UserInfoPage.lastNameTxtBox.isEnabled();
    }

    @When("Send valid lastname")
    public void send_valid_lastname() {
        us06UserInfoPage.lastNameTxtBox.clear();
        us06UserInfoPage.lastNameTxtBox.sendKeys("teamLastName");
    }

    @Then("Verify the lastname changed")
    public void verify_the_lastname_changed() {
    Assert.assertEquals("teamLastName",us06UserInfoPage.lastNameTxtBox.getText());
    }

    @When("Click on email box on userinfo page")
    public void click_on_email_box_on_userinfo_page() {
    us06UserInfoPage.emailTxtBox.click();
    }

    @When("Check if email is editable")
    public void check_if_email_is_editable() {
    us06UserInfoPage.emailTxtBox.isEnabled();
    }

    @When("Send valid email which include {string} and {string}")
    public void send_valid_email_which_include_and(String string, String string2) {
        us06UserInfoPage.emailTxtBox.clear();
     //Faker faker= new Faker();
     // String str=faker.name().firstName()+string+"gmail"+string2;
      us06UserInfoPage.emailTxtBox.sendKeys("teamfourtee"+string+"gmail"+string2);
    }

    @Then("Verify the email changed")
    public void verify_the_email_changed() {
    Assert.assertEquals("teamfourtee@gmail.com",us06UserInfoPage.emailTxtBox.getText());
    }





}
