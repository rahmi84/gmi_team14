package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.US14CreateANewAccountPage;
import utilities.Driver;
public class US_14 {
    US14CreateANewAccountPage us14CreateANewAccountPage=new US14CreateANewAccountPage();
    @Given("User signs in as employee to system")
    public void user_signs_in_as_employee_to_system() {
        Driver.loginAll("employee");
    }
    @Given("user clicks on My Operations")
    public void user_clicks_on_My_Operations() {
        us14CreateANewAccountPage.myOperationsDropdown.click();
    }
    @Given("user clicks on Manage Accounts")
    public void user_clicks_on_Manage_Accounts() {
        us14CreateANewAccountPage.drpManageAccounts.click();
    }
    @Given("user clicks on the Create a new Account")
    public void user_clicks_on_the_Create_a_new_Account() {
        us14CreateANewAccountPage.createANewAccount.click();
    }
    @Given("user enter the {string} as Description")
    public void user_enter_the_as_Description(String string) {
        us14CreateANewAccountPage.description.sendKeys(string);
    }
    @Given("user enter the {int} as Balance")
    public void user_enter_the_as_Balance(Integer int1) {
        us14CreateANewAccountPage.balance.sendKeys("56565");
    }
    @When("user enter the the creation date as {string} and creation time as {string}")
    public void user_enter_the_the_creation_date_as_and_creation_time_as(String string, String string2) {
        us14CreateANewAccountPage.createDate.sendKeys(string+string2);
    }
    @When("user clickc on account Save button")
    public void user_clickc_on_account_Save_button() {
        us14CreateANewAccountPage.save.click();
    }
    @Then("user sees green success message on the screen")
    public void user_sees_green_success_message_on_the_screen() {
        String actualText= Driver.getDriver().switchTo().alert().getText();
        System.out.println(actualText+"ben burdayim gordunmu beni");
    }
    @When("user goes manage accounts page")
    public void user_goes_manage_accounts_page() {
        us14CreateANewAccountPage.myOperationsDropdown.click();
    }
    @When("clicks on user id")
    public void clicks_on_user_id() {
        us14CreateANewAccountPage.idOfCustomer.click();
    }
}
