package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ConfigReader;
import utilities.Driver;

public class US002StepDefinitions {


    US002StepDefinitions regNegTest = new US002StepDefinitions();

        @Given("user is on home page")
        public void user_is_on_home_page(String string) {
            Driver.getDriver().get(ConfigReader.getProperty("url"));
        }

        @Given("user click on User button")
        public void user_click_on_User_button() {
           regNegTest.user_click_on_User_button();
        }

        @Given("user clicks Registration tab")
        public void user_clicks_Registration_tab() {
           regNegTest.user_clicks_the_Register_button();
        }

        @Given("click on SSN TextBox")
        public void click_on_SSN_TextBox() {
            regNegTest.click_on_SSN_TextBox();
        }

        @Then("user enters a invalid SSN number {string}")
        public void user_enters_a_invalid_SSN_number(String string) {
          
        }

        @Given("click on First Name TextBox")
        public void click_on_First_Name_TextBox() {
           
        }

        @Then("user enters a invalid First Name {string}")
        public void user_enters_a_invalid_First_Name(String string) {

        }

        @Given("click on Last Name TextBox")
        public void click_on_Last_Name_TextBox() {

        }

        @Then("user enters a invalid Last Name {string}")
        public void user_enters_a_invalid_Last_Name(String string) {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Given("click on Address TextBox")
        public void click_on_Address_TextBox() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Then("user enters invalid Address {string}")
        public void user_enters_invalid_Address(String string) {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Given("click on Mobile Phone Number TextBox")
        public void click_on_Mobile_Phone_Number_TextBox() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Then("user enters a invalid Mobil Phone Number {string}")
        public void user_enters_a_invalid_Mobil_Phone_Number(String string) {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Given("click on Username TextBox")
        public void click_on_Username_TextBox() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Then("user enters invalid username {string}")
        public void user_enters_invalid_username(String string) {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Given("click on Email TextBox")
        public void click_on_Email_TextBox() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Then("user enters invalid Email {string}")
        public void user_enters_invalid_Email(String string) {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Given("click on New password TextBox")
        public void click_on_New_password_TextBox() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Then("user enters invalid New password {string}")
        public void user_enters_invalid_New_password(String string) {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Given("Password strength level must be strong")
        public void password_strength_level_must_be_strong() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Given("click on New password confirmation TextBox")
        public void click_on_New_password_confirmation_TextBox() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Then("user enters invalid New password confirmation {string}")
        public void user_enters_invalid_New_password_confirmation(String string) {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Then("user clicks the Register button")
        public void user_clicks_the_Register_button() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Given("new click on SSN TextBox")
        public void new_click_on_SSN_TextBox() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Given("the user must type the character {string} - when entering a number into the current SSN TextBox.")
        public void the_user_must_type_the_character_when_entering_a_number_into_the_current_SSN_TextBox(String string) {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Then("ssn the user should not see the text {string}")
        public void ssn_the_user_should_not_see_the_text(String string) {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Given("new click on Mobile Phone Number TexttBox")
        public void new_click_on_Mobile_Phone_Number_TexttBox() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Given("user must type the\"<Tire>\" character - when entering a number into the valid Mobile Phone Number TextBox")
        public void user_must_type_the_Tire_character_when_entering_a_number_into_the_valid_Mobile_Phone_Number_TextBox() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Then("mobil the user should not see the text {string}.")
        public void mobil_the_user_should_not_see_the_text(String string) {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Given("new click on Email TextBox")
        public void new_click_on_Email_TextBox() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Given("the user is entering a valid Email TextBox Email Must use\"<email charecter>\" @  character and .com expression in TextBox")
        public void the_user_is_entering_a_valid_Email_TextBox_Email_Must_use_email_charecter_character_and_com_expression_in_TextBox() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Then("email the user should not see the text {string}.")
        public void email_the_user_should_not_see_the_text(String string) {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

}
