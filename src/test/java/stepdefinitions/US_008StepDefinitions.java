package stepdefinitions;


import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.US08PasswordSegmentPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_008StepDefinitions {
    US08PasswordSegmentPage us08PasswordSegmentPage=new US08PasswordSegmentPage();
    @Given("I am at the user password page")
    public void i_am_at_the_user_password_page() {
        US08PasswordSegmentPage.landMeOnPasswordChangeMenu("User");

    }

    @When("Click the current password box")
    public void click_the_current_password_box() {
        us08PasswordSegmentPage.currentPassword.click();

    }

    @Then("The current password box must be editable")
    public void the_current_password_box_must_be_editable() {
        Assert.assertTrue(us08PasswordSegmentPage.currentPassword.isEnabled());

    }

    @When("Enter the current password")
    public void enter_the_current_password() {
        us08PasswordSegmentPage.currentPassword.sendKeys(ConfigReader.getProperty("UserPassword"));

    }

    @When("Click the new password box")
    public void click_the_new_password_box() {
        us08PasswordSegmentPage.newPassword.click();

    }

    @Then("The new password box must be editable")
    public void the_new_password_box_must_be_editable() {
        Assert.assertTrue(us08PasswordSegmentPage.newPassword.isEnabled());

    }

    @Then("Enter the one of the old password as new one")
    public void enter_the_one_of_the_old_password_as_new_one() {
        us08PasswordSegmentPage.newPassword.sendKeys("oldpassword");

    }

    @When("Click the new password confirmation box")
    public void click_the_new_password_confirmation_box() {
        us08PasswordSegmentPage.confirmPassword.click();

    }

    @Then("Enter the same old password you just entered")
    public void enter_the_same_old_password_you_just_entered() {
        us08PasswordSegmentPage.confirmPassword.sendKeys("oldpassword");

    }

    @When("Click the save button")
    public void click_the_save_button() {
        us08PasswordSegmentPage.saveButton.click();

    }

    @Then("you should see the error message {string}")
    public void you_should_see_the_error_message(String string) {

    }

    @When("Enter the new password")
    public void enter_the_new_password() {
        us08PasswordSegmentPage.newPassword.sendKeys("yenipassword");

    }
    @Then("you should see the valid message {string}")
    public void you_should_see_the_valid_message(String string) {

    }

    @When("Enter the new password to the confirmation box")
    public void enter_the_new_password_to_the_confirmation_box() {
        us08PasswordSegmentPage.confirmPassword.sendKeys("yenipassword");

    }
    @When("I entered the new password with just lower-case chars between four and forty")
    public void i_entered_the_new_password_with_just_lower_case_chars_between_four_and_forty() {
       us08PasswordSegmentPage.newPassword.sendKeys(us08PasswordSegmentPage.passwordwithlowercase);
    }

    @Then("password strength should be one bar")
    public void password_strength_should_be_one_bar() {
        Assert.assertEquals("(241,340",us08PasswordSegmentPage.passwordStrenghBar.get(0).getLocation().toString());
    }

    @When("I entered the new password with just upper-case chars between four and forty")
    public void i_entered_the_new_password_with_just_upper_case_chars_between_four_and_forty() {
        us08PasswordSegmentPage.newPassword.sendKeys(us08PasswordSegmentPage.passwordwithUppercase);
    }

    @When("I entered the new password with just digit chars between four and forty")
    public void i_entered_the_new_password_with_just_digit_chars_between_four_and_forty() {
       us08PasswordSegmentPage.newPassword.sendKeys(us08PasswordSegmentPage.passwordDigit);
    }

    @When("I entered the new password with just special character chars between four and forty")
    public void i_entered_the_new_password_with_just_special_character_chars_between_four_and_forty() {
        us08PasswordSegmentPage.newPassword.sendKeys(us08PasswordSegmentPage.passwordChar);
    }

    @When("I entered the new password with {int} type chars between four and six")
    public void i_entered_the_new_password_with_type_chars_between_four_and_six(Integer int1) {
        us08PasswordSegmentPage.newPassword.sendKeys(us08PasswordSegmentPage.passwordValidWithEverything);

    }

    @When("I entered the new password with {int} type of chars \\(lower-upper) between seven and forty")
    public void i_entered_the_new_password_with_type_of_chars_lower_upper_between_seven_and_forty(Integer int1) {
       us08PasswordSegmentPage.newPassword.sendKeys(us08PasswordSegmentPage.passwordValidWithLower_Upper);
    }

    @Then("password strength should be three bar")
    public void password_strength_should_be_three_bar() {
        Assert.assertEquals("(283, 340)",us08PasswordSegmentPage.passwordStrenghBar.get(1).getLocation().toString());
        System.out.println(us08PasswordSegmentPage.passwordStrenghBar.get(2).getLocation().toString());
    }

    @When("I entered the new password with {int} type of chars  \\(lower-special) between seven and forty")
    public void i_entered_the_new_password_with_type_of_chars_lower_special_between_seven_and_forty(Integer int1) {
       us08PasswordSegmentPage.newPassword.sendKeys(us08PasswordSegmentPage.passwordValidWithLower_Char);
    }

    @When("I entered the new password with {int} type of chars  \\(lower-digit) between seven and forty")
    public void i_entered_the_new_password_with_type_of_chars_lower_digit_between_seven_and_forty(Integer int1) {
       us08PasswordSegmentPage.newPassword.sendKeys(us08PasswordSegmentPage.passwordValidWithLower_Digit);
    }

    @When("I entered the new password with {int} type of chars \\(upper-special) between seven and forty")
    public void i_entered_the_new_password_with_type_of_chars_upper_special_between_seven_and_forty(Integer int1) {
       us08PasswordSegmentPage.newPassword.sendKeys(us08PasswordSegmentPage.passwordValidWithUpper_Char);
    }

    @When("I entered the new password with {int} type of chars \\(upper-digit) between seven and forty")
    public void i_entered_the_new_password_with_type_of_chars_upper_digit_between_seven_and_forty(Integer int1) {
       us08PasswordSegmentPage.newPassword.sendKeys(us08PasswordSegmentPage.passwordValidWithUpper_Digit);
    }

    @When("I entered the new password with {int} type of chars \\(special-digit) between seven and forty")
    public void i_entered_the_new_password_with_type_of_chars_special_digit_between_seven_and_forty(Integer int1) {
        us08PasswordSegmentPage.newPassword.sendKeys(us08PasswordSegmentPage.passwordValidWithChar_Digit);
    }

    @When("I entered the new password with {int} type of chars \\(lower-upper-special) between seven and forty")
    public void i_entered_the_new_password_with_type_of_chars_lower_upper_special_between_seven_and_forty(Integer int1) {
       us08PasswordSegmentPage.newPassword.sendKeys(us08PasswordSegmentPage.passwordValidWithNoDigit);
    }

    @Then("password strength should be four bar")
    public void password_strength_should_be_four_bar() {


    }

    @When("I entered the new password with {int} type of chars \\(lower-upper-digit) between seven and forty")
    public void i_entered_the_new_password_with_type_of_chars_lower_upper_digit_between_seven_and_forty(Integer int1) {
       us08PasswordSegmentPage.newPassword.sendKeys(us08PasswordSegmentPage.passwordValidWithNoChar);
    }

    @When("I entered the new password with {int} type of chars \\(digit-upper-special) between seven and forty")
    public void i_entered_the_new_password_with_type_of_chars_digit_upper_special_between_seven_and_forty(Integer int1) {
       us08PasswordSegmentPage.newPassword.sendKeys(us08PasswordSegmentPage.getPasswordValidWithNolowercase);
    }

    @When("I entered the new password with {int} type of chars \\(lower-upper-digit-special) between seven and forty")
    public void i_entered_the_new_password_with_type_of_chars_lower_upper_digit_special_between_seven_and_forty(Integer int1) {
       us08PasswordSegmentPage.newPassword.sendKeys(us08PasswordSegmentPage.passwordValidWithEverything);
    }

    @Then("password strength should be five bar")
    public void password_strength_should_be_five_bar() {
        Assert.assertEquals("background-color: rgb(0, 255, 0);",us08PasswordSegmentPage.passwordStrenghBar.get(4).getAttribute("style"));
    }

    @When("I used space in the new password")
    public void i_used_space_in_the_new_password() {

    }

    @Then("the password should not be accepted")
    public void the_password_should_not_be_accepted() {
    }

    @When("I left the new password empty")
    public void i_left_the_new_password_empty() {

    }

    @When("Click new confirmation box")
    public void click_new_confirmation_box() {
        us08PasswordSegmentPage.confirmPassword.click();
    }

    @Then("I have to see error message {string}")
    public void i_have_to_see_error_message(String string) {

    }



}