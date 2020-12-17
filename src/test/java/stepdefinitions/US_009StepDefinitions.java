package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.SplittableRandom;

public class US_009StepDefinitions {

    US9US10US11EmployeeCreateOrEditACustomerPage myClass = new US9US10US11EmployeeCreateOrEditACustomerPage();
    US04SignInPage signPage = new US04SignInPage();
    US01$2RegisterPage registerPage = new US01$2RegisterPage();
    US13EmployeeManageAccountsPage us13 = new US13EmployeeManageAccountsPage();
    MainEmployeePage main = new MainEmployeePage();

    @Given("Navigate to GMI Bank Application")
    public void navigate_to_GMI_Bank_Application() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("A new customer click register button")
    public void a_new_customer_click_register_button() {

        signPage.menuButton.click();
        myClass.registerCustomerButton.click();

    }

    @Then("Customer provide all informations as as {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} and register")
    public void customer_provide_all_informations_as_as_and_register(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) throws InterruptedException {

        myClass.ssnBox.sendKeys(string);
        myClass.firstNameBox.sendKeys(string2);
        myClass.lastNameBox.sendKeys(string3);
        myClass.addressBox.sendKeys(string4);
        myClass.mobilePhoneNumberBox.sendKeys(string5);
        myClass.username.sendKeys(string6);
        myClass.emailBox.sendKeys(string7);
        myClass.newPasswordBox.sendKeys(string8);
        myClass.newPasswordConfirmation.sendKeys(string9);
        myClass.registerButton.click();
    }

    @When("Sign in as a {string}")
    public void sign_in_as_a(String string) {

        Driver.loginAll("employee");
    }

    @Then("Go to manage customers page")
    public void go_to_manage_customers_page() {

        main.myOperationsDropdown.click();
        myClass.manageCustomerButton.click();

    }

    @Then("Click Create a new Customers button")
    public void click_button() {

        myClass.createANewCustomerButton.click();
    }

    @Then("Search customer by customer's SSN")
    public void search_customer_by_customer_s_SSN() {

        myClass.ssnBox.sendKeys("123-45-8854");
        myClass.searchButton.click();
    }

}
