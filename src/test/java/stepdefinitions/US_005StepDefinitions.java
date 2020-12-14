package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.US04SignInPage;
import pages.US_005LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_005StepDefinitions {

    US04SignInPage loginPage=new US04SignInPage();
    US_005LoginPage loginPage2=new US_005LoginPage();

    @Given("User enters invalid username {string}")
    public void user_enters_invalid_username(String string) {
        Driver.wait(1);
        loginPage.username.sendKeys(string);
    }

    @When("User enters  valid password {string}")
    public void user_enters_valid_password(String string) {
        Driver.wait(1);
        loginPage.password.sendKeys(string);
    }

    @When("User clicks signIn button")
    public void user_clicks_signIn_button() {

        Driver.clickWithTimeOut(loginPage.submitSignInButton,3);
    }

    @Then("Validate error message")
    public void validate_error_message() {

        Driver.waitForVisibility(loginPage2.errorMessage,5);
    }

    @Then("click cancel button")
    public void click_cancel_button() {
        Driver.clickWithJS(loginPage2.cancelButton);

    }

    @Given("user enters  valid username {string}")
    public void user_enters_valid_username(String string) {
        Driver.wait(5);
        loginPage.username.sendKeys(ConfigReader.getProperty("CustomerUsername"));
    }

    @When("user enters  invalid password {string}")
    public void user_enters_invalid_password(String string) {

        loginPage.password.sendKeys(string);
    }

    @Then("user click cancel button")
    public void user_click_cancel_button() {

        Driver.clickWithTimeOut(loginPage2.cancelButton,2);
    }

    @Then("user write invalid mail")
    public void user_write_invalid_mail() {

        Assert.assertTrue(loginPage2.resetPasswordAlert.isDisplayed());
    }

    @Then("user click submit button")
    public void user_click_submit_button() {
       Driver.doubleClick(loginPage2.submitButton);
    }

    @When("User click Register a new account")
    public void user_click_Register_a_new_account() {
        Driver.doubleClick(loginPage2.registerNewButton);
    }

    @Then("User validate  navigate to registration page")
    public void user_validate_navigate_to_registration_page() {
       Driver.clickWithJS(loginPage2.registerNewButton);
    }





}
