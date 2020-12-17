package stepdefinitions;

import pages.LandingPage;

import pages.US01$2RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.MyMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class RegistrationPage_Step_Definitions {
    LandingPage landingPage = new LandingPage();
    US01$2RegisterPage registrationPage = new US01$2RegisterPage();



    @Given("User is on the {string} page")
    public void userIsOnThePage(String registration) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        landingPage.clickAccntMenu();
        landingPage.clickTo("Register");
    }
//
//    @When("User fill out {string} boxes with valid {string} credentials")
//    public void userFillOutBoxesWithValidCredentials(String input, String info) {
//
//        Driver.wait(3);
//        registrationPage.enterInfo(input,info);
//        Driver.wait(3);
//    }



    @When("User fill out input boxes with valid info credentials")
    public void user_fill_out_input_boxes_with_valid_info_credentials(List<Map<String,String>> dataTable) {

        System.out.println("dataTable = " + dataTable);

        for (Map<String,String> each : dataTable ){
            // each.put(registrationPage.fillBoxes();)
            //registrationPage.enterInfo(each.put());
            registrationPage.setSsn(each.get("ssn"));
            registrationPage.setFirstName(each.get("firstname"));
            registrationPage.setLastName(each.get("lastname"));
            registrationPage.setAddress(each.get("address"));
            registrationPage.setMobilePhoneNumber(each.get("mobilephone"));
            registrationPage.setEmail(each.get("email"));
            registrationPage.setUsername(each.get("username"));
            registrationPage.setNewPassword(each.get("new password"));
            registrationPage.setNewPasswordConfirmation(each.get("confirmation password"));
        }

    }


    @When("User fill out input boxes with invalid info credentials")
    public void user_fill_out_input_boxes_with_invalid_info_credentials(List<Map<String,String>> dataTable) {


        System.out.println("dataTable = " + dataTable);

        for (Map<String,String> each : dataTable ){
            // each.put(registrationPage.fillBoxes();)
            //registrationPage.enterInfo(each.put());
            registrationPage.setSsn(each.get("ssn"));
            registrationPage.setFirstName(each.get("firstname"));
            registrationPage.setLastName(each.get("lastname"));
            registrationPage.setAddress(each.get("address"));
            registrationPage.setMobilePhoneNumber(each.get("mobilephone"));
            registrationPage.setEmail(each.get("email"));
            registrationPage.setUsername(each.get("username"));
            registrationPage.setNewPassword(each.get("new password"));
            registrationPage.setNewPasswordConfirmation(each.get("confirmation password"));
        }

    }




//    @When("User fill out input boxes with invalid info credentials end see translation-not-found[Your SSN is required]")
//    public void user_fill_out_input_boxes_with_invalid_info_credentials_end_see_translation_not_found_your_ssn_is_required(io.cucumber.datatable.DataTable dataTable) {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//        // Double, Byte, Short, Long, BigInteger or BigDecimal.
//        //
//        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();
//    }




    @When("User fill out input boxes with invalid info credentials end see {string}")
    public void user_fill_out_input_boxes_with_invalid_info_credentials_end_see(List<Map<String,String>> dataTable,String errorMessage) {

        for (Map<String,String> each : dataTable ){
            // each.put(registrationPage.fillBoxes();)
            //registrationPage.enterInfo(each.put());
            registrationPage.setSsn(each.get("ssn"));
            registrationPage.setFirstName(each.get("firstname"));
            registrationPage.setLastName(each.get("lastname"));
            registrationPage.setAddress(each.get("address"));
            registrationPage.setMobilePhoneNumber(each.get("mobilephone"));
            registrationPage.setEmail(each.get("email"));
            registrationPage.setUsername(each.get("username"));
            registrationPage.setNewPassword(each.get("new password"));
            registrationPage.setNewPasswordConfirmation(each.get("confirmation password"));

        }



    }

//    @And("User see {string} when {string} are invalid")
//    public void userSeeWhenAreInvalid(String credentials, String errorMessage) {
//
//    }

    @When("Invalid {string} entered to {string} box user see {string} displayed")
    public void invalid_entered_to_box_user_see_displayed(String input, String credentials, String errorMessage) {
        registrationPage.getErrorMessage(input,credentials,errorMessage);
    }

    @And("Verify {string} message is displayed")
    public void verifyMessageIsDisplayed(String Message) {
        MyMethods.getDefaultMessage(Message);
    }

//end
}

