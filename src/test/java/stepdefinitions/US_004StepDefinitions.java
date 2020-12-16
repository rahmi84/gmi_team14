package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.US04SignInPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_004StepDefinitions {

    US04SignInPage loginPage=new US04SignInPage();

    @Given("User go to  home page {string}  page")
    public void user_go_to_home_page_page(String string) {

        Driver.getDriver().get(string);
    }

    @Given("User Should click on Loginmenu")
    public void user_Should_click_on_Loginmenu() {

        Driver.clickWithTimeOut(loginPage.menuButton,3);
    }

    @Given("ThenUser click  sign in")
    public void thenuser_click_sign_in() {

        Driver.clickWithTimeOut(loginPage.signIn,3);
    }

    @Given("User send text usernamebox")
    public void user_send_text_usernamebox() {
        Driver.wait(5);
        loginPage.username.sendKeys(ConfigReader.getProperty("CustomerUsername"));
    }

    @When("User send text passwordbox")
    public void user_send_text_passwordbox() throws InterruptedException {
        Driver.wait(5);
       loginPage.password.sendKeys(ConfigReader.getProperty("CustomerPassword"));
    }

    @When("User click sign in button")
    public void user_click_sign_in_button() throws InterruptedException {
        //Thread.sleep(30);
     Driver.clickWithTimeOut(loginPage.submitSignInButton,3);
    }

    @Then("User validates name on page")
    public void user_validates_name_on_page() {
        Driver.wait(5);
        Assert.assertTrue(loginPage.usernameValidate.isDisplayed());
    }
    @Then("click Sign out menu")
    public void click_Sign_out_menu() {
        loginPage.usernameValidate.click();
        loginPage.SignOutMenu.click();
    }


    @Then("There should be an option to cancel button")
    public void there_should_be_an_option_to_cancel_button()  throws InterruptedException {
        Thread.sleep(30);
    loginPage.cancelButton.click();
    }


}
