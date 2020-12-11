package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.Driver;

public class LoginPageStepDefinitions {
    LogInPage signIn=new LogInPage();

    @Given("user go to home page {string}")
    public void user_go_to_home_page(String string) {

        Driver.getDriver().get(string);
    }
/*
    @When("user click  menu")
    public void user_click_menu() {

    }

    @When("user click sign in")
    public void user_click_sign_in() {

    }

    @When("user send  text loginusername")
    public void user_send_text_loginusername() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user send text loginpassword")
    public void user_send_text_loginpassword() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user click sign in box")
    public void user_click_sign_in_box() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
*/







}
