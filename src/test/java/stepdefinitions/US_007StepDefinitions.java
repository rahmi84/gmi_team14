package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.US06UserInfoPage;

public class US_007StepDefinitions {

    US06UserInfoPage us06UserInfoPage= new US06UserInfoPage();

    @When("Click the current email box")
    public void click_the_current_email_box() {

    }

    @When("Delete {string}")
    public void delete(String string) {

    }

    @When("Send key {string}")
    public void send_key(String string) {

    }

    @When("Click save button to see error message")
    public void click_save_button_to_see_error_message() {

    }

    @Then("Verify the error message")
    public void verify_the_error_message() {

    }

    @When("Click the language box")
    public void click_the_language_box() {

    }

    @When("Select from dropdown menu Turkish and English options")
    public void select_from_dropdown_menu_Turkish_and_English_options() {

    }

    @When("Check if it is another option")
    public void check_if_it_is_another_option() {

    }

    @Then("Verify  languages which is in dropdown menu")
    public void verify_languages_which_is_in_dropdown_menu() {

    }
    @When("Click on firstname box")
    public void click_on_firstname_box() {

    }

    @When("Send invalid firstname for {string}")
    public void send_invalid_firstname_for(String string) {

    }

    @When("Click on lastname box")
    public void click_on_lastname_box() {

    }

    @When("Send invalid lastname for {string}")
    public void send_invalid_lastname_for(String string) {

    }

    @When("click save botton to see error message")
    public void click_save_botton_to_see_error_message() {

    }

    @Then("Verify the error message for lastname and firstname")
    public void verify_the_error_message_for_lastname_and_firstname() {

    }



}
