package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;

import java.util.SplittableRandom;
public class US_010StepDefinitions {

    US9US10US11EmployeeCreateOrEditACustomerPage myClass = new US9US10US11EmployeeCreateOrEditACustomerPage();
    US13EmployeeManageAccountsPage us13 = new US13EmployeeManageAccountsPage();
    US01RegisterPage registerPage = new US01RegisterPage();

    @Given("I should provide customer all informations as {string} , {string} , {string} , {string} , {string} , {string}")
    public void i_should_provide_custumer_all_informations_as(String string, String string2, String string3, String string4, String string5, String string6) {

        myClass.middleInitialBox.sendKeys(string);
        myClass.phoneNumberBox.sendKeys(string2);
        myClass.zipCodeBox.sendKeys(string3);
        myClass.cityBox.sendKeys(string4);
        myClass.countrySelectBox.sendKeys(string5);
        myClass.stateBox.sendKeys(string6);
        myClass.saveBox.click();
    }

    @Given("I should verify address as {string} has not left blank")
    public void i_should_verify_address_as_has_not_left_blank(String address) {

        String expectedAddress = address.trim();
        Assert.assertEquals(expectedAddress,address);
    }

    @When("I should verify city as {string} has not left blank")
    public void i_should_verify_city_as_has_not_left_blank(String city) {

        String expectedCity = city.trim();
        Assert.assertEquals(expectedCity,city);
    }

    @Then("I should verify country as {string} has not left blank")
    public void i_should_verify_country_as_has_not_left_blank(String country) {

        String expectedCountry = country.trim();
        Assert.assertEquals(expectedCountry,country);
    }

    @And("I should verify state as {string} has not left blank")
    public void i_should_verify_state_as_has_not_left_blank(String state) {

        String expectedState = state.trim();
        Assert.assertEquals(expectedState,state);
        myClass.saveBox.click();
    }


}
