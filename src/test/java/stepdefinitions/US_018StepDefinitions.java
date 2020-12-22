package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.US13EmployeeManageAccountsPage;
import pages.US15CustomerMyAccountPage;
import pages.US_18manageCustomerPage;
import utilities.Driver;

public class US_018StepDefinitions {

    US15CustomerMyAccountPage us15CustomerMyAccountPage = new US15CustomerMyAccountPage();
    US_18manageCustomerPage us_18manageCustomerPage = new US_18manageCustomerPage();

    @Given("admin should go to homepage and signIn Customer Account")
    public void user_should_go_to_homepage_and_signIn_Customer_Account() {
        US_18manageCustomerPage.AdminLogin();
    }

    @Given("admin clicks My Operations")
    public void clicks_My_Operations() {
        Driver.clickWithTimeOut(us15CustomerMyAccountPage.myOperationsButton, 1);

    }

    @Given("admin clicks My Accounts")
    public void clicks_My_Accounts() {
        Driver.wait(1);
        Driver.clickWithTimeOut(us15CustomerMyAccountPage.myAccountsButton, 1);

    }

    @Then("Verify admin can see all  populating the account information of the customer{string} {string}  {string} {string}  {string}  {string}  {string} {string}")
    public void verifyAdminCanSeeAllPopulatingTheAccountInformationOfTheCustomer(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) {
        for (WebElement eachcustomerInformation : us_18manageCustomerPage.customerInformationList) {
            System.out.println("tc1" + "=" + eachcustomerInformation.getText());

            Assert.assertTrue(us_18manageCustomerPage.customerInformationList.size() > 0);

        }
    }

    @When("Click the language view menu")
    public void clickTheLanguageViewMenu() {
        us_18manageCustomerPage.viewElement.click();

    }

    @And("See all customer info on that page")
    public void seeAllCustomerInfoOnThatPage() {
        for (WebElement eachcustomerInformationPage : us_18manageCustomerPage.viewCustomerInfolist) {
            System.out.println("tc2" + "=" + eachcustomerInformationPage.getText());

            Assert.assertTrue(us_18manageCustomerPage.viewCustomerInfolist.size() > 0);

        }


    }

    @Then("Verify edit button there")
    public void verifyEditButtonThere() {


        Driver.scrollToElement(us_18manageCustomerPage.editButtonElement);
        System.out.println(us_18manageCustomerPage.editButtonElement.getText());


    }

    @When("Click  edit button")
    public void clickEditButton() {
        us_18manageCustomerPage.editButtonElement.click();

    }

    @And("See all customer info populated")
    public void seeAllCustomerInfoPopulated() {
        Driver.scrollToElement(us_18manageCustomerPage.saveButtonPopulate);
        for (WebElement eachcustomerInformationpopulate : us_18manageCustomerPage.editCustomerInfoList) {
            System.out.println("tc3" + "=" + eachcustomerInformationpopulate.getText());

            Assert.assertTrue(us_18manageCustomerPage.editCustomerInfoList.size() > 0);


        }
    }

    @When("Click  delete button")
    public void clickDeleteButton() {
         us_18manageCustomerPage.deleteButtonElement.click();
    }

    @And("click delete on confirmation box")
    public void clickDeleteConfirmationBox() {

        us_18manageCustomerPage.deleteConfimationElement.click();
    }

    @Then("verify customer is deleted")
    public void verifyCustomerIsDeleted() {

            String successMessageActual = US13EmployeeManageAccountsPage.JsGetText(us_18manageCustomerPage.deleteVerifyElement);
            String  successMessageExpected="Toastify__toast-container Toastify__toast-container--top-left toastify-container";
            Assert.assertEquals(successMessageActual,successMessageExpected);
        }

    }
