package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;

import org.openqa.selenium.Alert;
import pages.US13EmployeeManageAccountsPage;
import sun.reflect.generics.scope.Scope;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class US_013stepDefinitions {

    US13EmployeeManageAccountsPage US13EmployeeManageAccountsPage = new US13EmployeeManageAccountsPage();

    @Given("sign in as employee role")
    public void signInAsEmployeeRole() {
        US13EmployeeManageAccountsPage.signInAsrole("employee");

    }

    @Given("^user click  create a new account$")
    public void user_click_create_a_new_account() {
        US13EmployeeManageAccountsPage.manageOperationElement.click();
        US13EmployeeManageAccountsPage.manageAccountElement.click();
        US13EmployeeManageAccountsPage.EmployeeCreateaNewAccountElemenet.click();
    }

    @When("^enter a (.+)$")
    public void enter_a(String description) {
        US13EmployeeManageAccountsPage.descriptionElement.sendKeys(description);
    }


    @When("^enter balance as (.+)$")
    public void enter_balance_as(String balance) {
        US13EmployeeManageAccountsPage.balanceElement.sendKeys(balance);

        ArrayList<Character> c = new ArrayList<Character>();
        c.add('$');
        c.add('€');
        for (int i = 0; i < 2; i++) {
            if (balance.contains(String.valueOf(c.get(i)))) {
                Assert.assertTrue(US13EmployeeManageAccountsPage.blankBalanceErrorElement.isDisplayed());
            }
        }
    }

    @When("^select (.+) account type$")
    public void select_account_type(String accounttype) {
        US13EmployeeManageAccountsPage.selectAccounType(accounttype);
    }

    @When("^select account status (.+)$")
    public void select_account_status(String accountstatus) {
        US13EmployeeManageAccountsPage.selectAccountStatusType(accountstatus);
    }

    @Then("^success massage display$")
    public void success_massage_display() {
        String actualSuccesMessage = pages.US13EmployeeManageAccountsPage.getAlert();
        String expectedSucessMessage = "translation-not-found[gmiBankBackendApp.tPAccount.created]";

        Assert.assertEquals(actualSuccesMessage, expectedSucessMessage);
    }

    @And("^save form$")
    public void save_form() {
        US13EmployeeManageAccountsPage.saveButtonElement.click();
    }


    @Then("navigate to home page")
    public void navigateToHomePage() {
        US13EmployeeManageAccountsPage.headerHomeButtonElement.click();
    }

    @Then("error box content")
    public void errorBoxContent() {

    }

    @But("^error box content")
    public void error_box_content_() throws Throwable {

            Assert.assertTrue(US13EmployeeManageAccountsPage.blankBalanceErrorElement.isDisplayed());

            Assert.assertTrue(US13EmployeeManageAccountsPage.descriptionInvalidElement.isDisplayed());

        }
    }







