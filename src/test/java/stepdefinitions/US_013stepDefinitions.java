package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.MainEmployeePage;
import pages.US13EmployeeManageAccountsPage;
import utilities.Driver;
import java.util.ArrayList;

public class US_013stepDefinitions {

    US13EmployeeManageAccountsPage uS13EmployeeManageAccountsPage = new US13EmployeeManageAccountsPage();
    MainEmployeePage mainEmployeePage = new MainEmployeePage();


    @Given("login  as employee")
    public void loginAsEmployee() {


        Driver.loginAll("employee");
    }

    @Then("^user click  create a new account$")
    public void user_click_create_a_new_account() {


        mainEmployeePage.myOperationsDropdown.click();
        mainEmployeePage.drpManageAccounts.click();
        uS13EmployeeManageAccountsPage.EmployeeCreateaNewAccountElemenet.click();
    }

    @Given("^enter a (.+)$")
    public void enter_a(String description) {
        Driver.wait(2);

        uS13EmployeeManageAccountsPage.descriptionElement.sendKeys(description);
    }


    @When("^enter balance as (.+)$")
    public void enter_balance_as(String balance) {

        uS13EmployeeManageAccountsPage.balanceElement.sendKeys(balance);

        ArrayList<Character> c = new ArrayList<>();
        c.add('$');
        c.add('€');
        for (int i = 0; i < 2; i++) {
            if (balance.contains(String.valueOf(c.get(i)))) {
                Assert.assertTrue(uS13EmployeeManageAccountsPage.blankBalanceErrorElement.isDisplayed());
            }
        }
    }

    @When("^select (.+) account type$")
    public void select_account_type(String accounttype) {

        uS13EmployeeManageAccountsPage.selectAccounType(accounttype);
    }

    @When("^select account status (.+)$")
    public void select_account_status(String accountstatus) {

        uS13EmployeeManageAccountsPage.selectAccountStatusType(accountstatus);
    }

    @When("click employee dropdown menu")
    public void clickEmployeeDropdownMenu() {
        uS13EmployeeManageAccountsPage.employeeClickElement.click();
    }



    @And("^save form$")
    public void save_form() {


        uS13EmployeeManageAccountsPage.saveButtonElement.click();
    }

    @But("^error box content")
    public void error_box_content_() {


            Assert.assertTrue(uS13EmployeeManageAccountsPage.blankBalanceErrorElement.isDisplayed());

            Assert.assertTrue(uS13EmployeeManageAccountsPage.descriptionInvalidElement.isDisplayed());


    }

    @Then("Success message is displayed")
    public void successMessageIsDisplayed() {
        String successMessageActual = US13EmployeeManageAccountsPage.JsGetText(uS13EmployeeManageAccountsPage.saveSuccessMessage);
        String  successMessageExpected="translation-not-found[gmiBankBackendApp.tPAccount.created]";
        Assert.assertEquals(successMessageActual,successMessageExpected);
    }

}







