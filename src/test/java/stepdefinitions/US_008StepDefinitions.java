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

    @When("Enter the current password {string}")
    public void enter_the_current_password(String currentpassword) {
       us08PasswordSegmentPage.currentPassword.sendKeys(currentpassword);
    }
    @When("Enter the new password {string}")
    public void enter_the_new_password(String newpassword) {
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @When("Enter the new password to the confirmation box {string}")
    public void enter_the_new_password_to_the_confirmation_box(String newpassword) {
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);

    }


    @When("Click the new password box")
    public void click_the_new_password_box() {
        us08PasswordSegmentPage.newPassword.click();
    }

    @Then("The new password box must be editable")
    public void the_new_password_box_must_be_editable() {
        Assert.assertTrue(us08PasswordSegmentPage.newPassword.isEnabled());
    }

    @Then("Enter the one of the old password as new one {string}")
    public void enter_the_one_of_the_old_password_as_new_one(String newpassword) {
      us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }
    @When("Click the new password confirmation box")
    public void click_the_new_password_confirmation_box() {
        us08PasswordSegmentPage.confirmPassword.click();
    }

    @Then("The new password confirmation box must be editable")
    public void the_new_password_confirmation_box_must_be_editable() {
      Assert.assertTrue(us08PasswordSegmentPage.confirmPassword.isEnabled());
    }

    @When("Click the save button")
    public void click_the_save_button() {
  //     us08PasswordSegmentPage.saveButton.click();
    }

    @Then("you should see the error message {string}")
    public void you_should_see_the_error_message(String message) {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(message));
    }




    @Then("you should see the valid message {string}")
    public void you_should_see_the_valid_message(String message) {
      Assert.assertTrue(Driver.getDriver().getPageSource().contains(message));
    }

    @When("I entered the new password with just lower-case chars between four and six")
    public void i_entered_the_new_password_with_just_lower_case_chars_between_four_and_six() {
        String newpassword=us08PasswordSegmentPage.passwordwithlowercase4_6;
        System.out.println("The password is  (lowercase 4-6)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);;

    }

    @Then("password strength should be one bar")
    public void password_strength_should_be_one_bar() {
        Assert.assertEquals("background-color: rgb(255, 0, 0);",us08PasswordSegmentPage.passwordStrenghBar.get(0).getAttribute("style"));
        Assert.assertEquals("background-color: qrgb(221, 221, 221);",us08PasswordSegmentPage.passwordStrenghBar.get(1).getAttribute("style"));
    }

    @When("I entered the new password with just upper-case chars between four and six")
    public void i_entered_the_new_password_with_just_upper_case_chars_between_four_and_six() {
        String newpassword=us08PasswordSegmentPage.passwordwithUppercase4_6;
        System.out.println("The password is  (uppercase 4-6)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);


    }

    @When("I entered the new password with just digit chars between four and six")
    public void i_entered_the_new_password_with_just_digit_chars_between_four_and_six() {
        String newpassword=us08PasswordSegmentPage.passwordDigit4_6;
        System.out.println("The password is  (digit 4-6)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @When("I entered the new password with just special character chars between four and six")
    public void i_entered_the_new_password_with_just_special_character_chars_between_four_and_six() {
        String newpassword=us08PasswordSegmentPage.passwordChar4_6;
        System.out.println("The password is  (special 4-6)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @When("I entered the new password with four type chars between four and six")
    public void i_entered_the_new_password_with_four_type_chars_between_four_and_six() {
        String newpassword=us08PasswordSegmentPage.passwordValidWithEverythingBtw4_6;
        System.out.println("The password is  (for types 4-6)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @When("I entered the new password with just lower-case chars between seven and forty")
    public void i_entered_the_new_password_with_just_lower_case_chars_between_seven_and_forty() {
        String newpassword=us08PasswordSegmentPage.passwordwithlowercase7_40;
        System.out.println("The password is  (lowercase 7-40)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @Then("password strength should be two bar")
    public void password_strength_should_be_two_bar() {
        Assert.assertEquals("background-color: rgb(255, 153, 0);",us08PasswordSegmentPage.passwordStrenghBar.get(1).getAttribute("style"));
        Assert.assertEquals("background-color: rgb(221, 221, 221);",us08PasswordSegmentPage.passwordStrenghBar.get(2).getAttribute("style"));
    }

    @When("I entered the new password with just upper-case chars between seven and forty")
    public void i_entered_the_new_password_with_just_upper_case_chars_between_seven_and_forty() {
        String newpassword=us08PasswordSegmentPage.passwordwithUppercase7_40;
        System.out.println("The password is  (uppercase 7-40)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);

    }

    @When("I entered the new password with just digit chars between seven and forty")
    public void i_entered_the_new_password_with_just_digit_chars_between_seven_and_forty() {
        String newpassword=us08PasswordSegmentPage.passwordDigit7_40;
        System.out.println("The password is  (digit 7-40)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);

    }

    @When("I entered the new password with just special character chars between seven and forty")
    public void i_entered_the_new_password_with_just_special_character_chars_between_seven_and_forty() {
        String newpassword=us08PasswordSegmentPage.passwordChar7_40;
        System.out.println("The password is  (special 7-40)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);

    }

    @When("I entered the new password with two type of chars \\(lower-upper) between seven and forty")
    public void i_entered_the_new_password_with_two_type_of_chars_lower_upper_between_seven_and_forty() {
        String newpassword=us08PasswordSegmentPage.passwordValidWithLower_Upper;
        System.out.println("The password is  (lower-upper 7-40)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);

    }

    @Then("password strength should be three bar")
    public void password_strength_should_be_three_bar() {
        Assert.assertEquals("background-color: rgb(153, 255, 0);",us08PasswordSegmentPage.passwordStrenghBar.get(2).getAttribute("style"));
        Assert.assertEquals("background-color: rgb(221, 221, 221);",us08PasswordSegmentPage.passwordStrenghBar.get(3).getAttribute("style"));

    }

    @When("I entered the new password with two type of chars  \\(lower-special) between seven and forty")
    public void i_entered_the_new_password_with_two_type_of_chars_lower_special_between_seven_and_forty() {
        String newpassword=us08PasswordSegmentPage.passwordValidWithLower_Char;
        System.out.println("The password is  (lower-special 7-40)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @When("I entered the new password with two type of chars  \\(lower-digit) between seven and forty")
    public void i_entered_the_new_password_with_two_type_of_chars_lower_digit_between_seven_and_forty() {
        String newpassword=us08PasswordSegmentPage.passwordValidWithLower_Digit;
        System.out.println("The password is  (lower-digit 7-40)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @When("I entered the new password with two type of chars \\(upper-special) between seven and forty")
    public void i_entered_the_new_password_with_two_type_of_chars_upper_special_between_seven_and_forty() {
        String newpassword=us08PasswordSegmentPage.passwordValidWithUpper_Char;
        System.out.println("The password is  (upper-special 7-40)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @When("I entered the new password with two type of chars \\(upper-digit) between seven and forty")
    public void i_entered_the_new_password_with_two_type_of_chars_upper_digit_between_seven_and_forty() {
        String newpassword=us08PasswordSegmentPage.passwordValidWithUpper_Digit;
        System.out.println("The password is  (upper-digit 7-40)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @When("I entered the new password with two type of chars \\(special-digit) between seven and forty")
    public void i_entered_the_new_password_with_two_type_of_chars_special_digit_between_seven_and_forty() {
        String newpassword=us08PasswordSegmentPage.passwordValidWithChar_Digit7_40;
        System.out.println("The password is  (special-digit 7-40)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @When("I entered the new password with three type of chars \\(lower-upper-special) between seven and forty")
    public void i_entered_the_new_password_with_three_type_of_chars_lower_upper_special_between_seven_and_forty() {
        String newpassword=us08PasswordSegmentPage.passwordValidWithNoDigit;
        System.out.println("The password is  (lower-upper-special 7-40)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @Then("password strength should be four bar")
    public void password_strength_should_be_four_bar() {
        Assert.assertEquals("background-color: rgb(153, 255, 0);",us08PasswordSegmentPage.passwordStrenghBar.get(3).getAttribute("style"));
        Assert.assertEquals("background-color: rgb(221, 221, 221);",us08PasswordSegmentPage.passwordStrenghBar.get(4).getAttribute("style"));

    }

    @When("I entered the new password with three type of chars \\(lower-upper-digit) between seven and forty")
    public void i_entered_the_new_password_with_three_type_of_chars_lower_upper_digit_between_seven_and_forty() {
        String newpassword=us08PasswordSegmentPage.passwordValidWithNoChar;
        System.out.println("The password is  (lower-upper-digit 7-40)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @When("I entered the new password with three type of chars \\(digit-upper-special) between seven and forty")
    public void i_entered_the_new_password_with_three_type_of_chars_digit_upper_special_between_seven_and_forty() {
        String newpassword=us08PasswordSegmentPage.getPasswordValidWithNolowercase;
        System.out.println("The password is  (digit-upper-special 7-40)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @When("I entered the new password with four type of chars \\(lower-upper-digit-special) between seven and forty")
    public void i_entered_the_new_password_with_four_type_of_chars_lower_upper_digit_special_between_seven_and_forty() {
        String newpassword=us08PasswordSegmentPage.passwordValidWithEverything;
        System.out.println("The password is  (lower-upper-digit-special 7-40)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @Then("password strength should be five bar")
    public void password_strength_should_be_five_bar() {
        Assert.assertEquals("background-color: rgb(0, 255, 0);",us08PasswordSegmentPage.passwordStrenghBar.get(4).getAttribute("style"));

    }

    @When("I used space in the new password")
    public void i_used_space_in_the_new_password() {
        String newpassword=us08PasswordSegmentPage.passwordValidWithEverythingandspace;
        System.out.println("The password is  everything with space)"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @Then("the password should not be accepted")
    public void the_password_should_not_be_accepted() {
       Assert.assertTrue(us08PasswordSegmentPage.newPasswordInvalidFeedback.isDisplayed());
    }

    @When("I left the new password empty")
    public void i_left_the_new_password_empty() {
        String newpassword=us08PasswordSegmentPage.passordempty;
        System.out.println("The password is  empty"+newpassword);
        us08PasswordSegmentPage.newPassword.sendKeys(newpassword);
    }
    @Then("I have to see error message {string}")
    public void i_have_to_see_error_message(String message) {
       Assert.assertEquals(message,us08PasswordSegmentPage.confirmNewPasswordInvalidFeedback.getText());
    }



}

