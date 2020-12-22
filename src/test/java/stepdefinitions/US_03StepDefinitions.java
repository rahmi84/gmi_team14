package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.US01$2RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_03StepDefinitions {
    HomePage homePage = new HomePage();
    US01$2RegisterPage registerPage = new US01$2RegisterPage();

    @FindBy(xpath = "//input[@name='ssn']")
    private WebElement ssnButton;

    @Given("user at the home page")
    public void user_at_the_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @And("user clicks menu")
    public void userClicksMenu() throws InterruptedException {
        homePage.userMenu.click();
        homePage.userRegistrationButton.click();
    }

    @And("user at the registration page and clicks ssn box and sends the ssnNumber")
    public void userAtTheRegistrationPageAndClicksSsnBoxAndSendsTheSsnNumber() {

        registerPage.setSsn("123-58-4587");
    }

    @Given("user clicks firstName box and sends the firstName")
    public void user_clicks_firstName_box_and_sends_the_firstName() {
        registerPage.setFirstName("Deniz");

    }

    @Given("user clicks lastName box and sends the lastName")
    public void user_clicks_lastName_box_and_sends_the_lastName() {

        registerPage.setLastName("Ocean");
    }

    @Given("user clicks address box and sends the address")
    public void user_clicks_address_box_and_sends_the_address() {
        registerPage.setAddress("350 Edgewood Dr.Oxford, MS 38655");
    }

    @Given("user clicks phoneNumber box and sends the phoneNumber")
    public void user_clicks_phoneNumber_box_and_sends_the_phoneNumber() {
        registerPage.setMobilePhoneNumber("365-485-2578");
    }


    @Given("user clicks userName box and sends the userName")
    public void user_clicks_userName_box_and_sends_the_userName() {
        registerPage.setUsername("DenizOcean");
    }

    @Given("user clicks email box and sends the email")
    public void user_clicks_email_box_and_sends_the_email() {

        registerPage.setEmail("DenizOcean@gmail.com");
    }

    @Given("user clicks password box and sends the password")
    public void user_clicks_password_box_and_sends_the_password() {
        String password = "Kk1@ljr";
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                System.out.println("There is one lowercase");
                continue;
                if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                    System.out.println("There is one uppercase");
                    continue;
                    if (password.charAt(i) >= '!' && password.charAt(i) <= '/') {
                        (password.charAt(i) >= ':' && password.charAt(i) <= '@')

                    }
                    System.out.println("There is one digit");
                    continue;
                    if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                        System.out.println("There is one Uppercase");
                        continue;


                    }

                    registerPage.setNewPassword(password);

//        There should be at least 1 lowercase char for stronger password and
//        see the level chart change accordingly
//        There should be at least 1 lowercase char and see the level  chart change accordingly
//        There should be at least 1 digit  and see the level  chart change accordingly
//        There should be at least 1 special char and see the level bar change accordingly
//    There should be at least 7 chars for a stronger password

                }
            }
        }
    }
    @Then("check the password if it meets with the acceptance criterias")
    public void checkThePasswordIfItMeetsWithTheAcceptanceCriterias() {
    }


}
