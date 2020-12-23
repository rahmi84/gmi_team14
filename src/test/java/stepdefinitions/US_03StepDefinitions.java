package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.US01$2RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_03StepDefinitions {
    HomePage homePage = new HomePage();
    US01$2RegisterPage registerPage = new US01$2RegisterPage();


    @Given("user at the home page")
    public void user_at_the_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @And("user clicks menu")
    public void userClicksMenu() throws InterruptedException {
        homePage.userMenu.click();
        homePage.userRegistrationButton.click();
    }

    @And("user at the registration page and clicks ssn box and sends the ssnnumber {string}")
    public void userAtTheRegistrationPageAndClicksSsnBoxAndSendsTheSsnnumber(String ssn) {
        registerPage.ssn.sendKeys(ssn);
    }

    @And("user clicks firstName box and sends the firstname {string}")
    public void userClicksFirstNameBoxAndSendsTheFirstname(String firstname) {
        registerPage.firstName.sendKeys(firstname);
    }

    @And("user clicks lastName box and sends the  lastName {string}")
    public void userClicksLastNameBoxAndSendsTheLastName(String lastname) {
        registerPage.lastname.sendKeys(lastname);
    }

    @And("user clicks address box and sends the  address {string}")
    public void userClicksAddressBoxAndSendsTheAddress(String address) {
        registerPage.Address.sendKeys(address);
    }

    @And("user clicks phoneNumber box and sends the phoneNumber {string}")
    public void userClicksPhoneNumberBoxAndSendsThePhoneNumber(String phoneNumber) {
        registerPage.MobilePhoneNumber.sendKeys(phoneNumber);

    }

    @And("user clicks userName box and sends the  userName {string}")
    public void userClicksUserNameBoxAndSendsTheUserName(String userName) {
        registerPage.username.sendKeys(userName);
    }

    @And("user clicks email box and sends the  email {string}")
    public void userClicksEmailBoxAndSendsTheEmail(String email) {
        registerPage.Email.sendKeys(email);
    }

    @And("user clicks the password box and sends the  password {string}")
    public void userClicksThePasswordBoxAndSendsThePassword(String password) {
        registerPage.NewPassword.sendKeys(password);
    }

    @And("user clicks the password box and sends the secondPassword {string}")
    public void userClicksThePasswordBoxAndSendsTheSecondPassword(String secondPassword) {
        registerPage.NewPasswordConfirmation.sendKeys(secondPassword);
    }

    @Then("user clicks the RegisterButton")
    public void userClicksTheRegisterButton() {
        registerPage.register.click();
    }
}


