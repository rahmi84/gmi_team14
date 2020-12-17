package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.US15CustomerMyAccountPage;
import utilities.Driver;

public class US_015_StepDefinitions {

    US15CustomerMyAccountPage us15CustomerMyAccountPage = new US15CustomerMyAccountPage();

    @Given("user should go to homepage and signIn Customer Account")
    public void user_should_go_to_homepage_and_signIn_Customer_Account() {
        Driver.loginAll("customer");

    }

    @Given("clicks My Operations")
    public void clicks_My_Operations() {
        Driver.clickWithTimeOut(us15CustomerMyAccountPage.myOperationsButton,1);

    }

    @Given("clicks My Accounts")
    public void clicks_My_Accounts() {
        Driver.wait(1);
        Driver.clickWithTimeOut(us15CustomerMyAccountPage.myAccountsButton,1);

    }

    @Then("Verify user can see all account types and balance populated")
    public void user_can_see_all_account_types_and_balance_populated() {
        Driver.wait(1);
        for (WebElement eachAccount : us15CustomerMyAccountPage.accountType) {
            System.out.println(eachAccount.getText());
        }

        for (WebElement eachBalance : us15CustomerMyAccountPage.accountBalance) {
            System.out.println(eachBalance.getText());
        }
      //  Assert.assertTrue(us15CustomerMyAccountPage.accountType.size()>0);
       // Assert.assertTrue(us15CustomerMyAccountPage.accountBalance.size()>0);
    }

    @And("user signOut")
    public void user_signOut() {
        us15CustomerMyAccountPage.usernameValidate.click();
        Driver.wait(1);
        us15CustomerMyAccountPage.singOutButton.click();

    }

    @Given("user clicks View Transaction Buttons")
    public void user_clicks_View_Transaction_Buttons() {
        Driver.wait(1);
        us15CustomerMyAccountPage.viewTransactionButton.click();

    }

    @Then("Verify user can see all view transaction")
    public void user_can_see_all_view_transaction() {
        for (WebElement eachTransaction : us15CustomerMyAccountPage.transactions) {
            System.out.println(eachTransaction.getText());
            Driver.wait(1);
        }

        us15CustomerMyAccountPage.viewTransactionButton2.click();
        Driver.wait(1);
        for (WebElement eachTransaction : us15CustomerMyAccountPage.transactions) {
            System.out.println(eachTransaction.getText());
        }

        Assert.assertTrue(us15CustomerMyAccountPage.transactions.size()>0);

    }


}
