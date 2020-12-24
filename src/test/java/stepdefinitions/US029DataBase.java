package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.DataBaseUtil;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class US029DataBase {
    String userDataQuery = "SELECT * FROM " + ConfigReader.getProperty("usersTableName");
    //String userDataQuery ="select  * FROM  public.jhi_user";
    ResultSet resultSetUser;
    List<String> userFirstName = new ArrayList<>();

    ResultSet resultSetCountry;
    String countriesDataQuery = "SELECT *  FROM " + ConfigReader.getProperty("countriesTableName");
    List<String> countryList = new ArrayList<>();

    ResultSet resultSetStates;
    String statesDataQuery = "SELECT * FROM " + ConfigReader.getProperty("statesTableName");
    List<String> statesList = new ArrayList<>();


    @Given("user connecting GMI database")
    public void user_connecting_GMI_database() {
        resultSetUser = DataBaseUtil.getResultSet(userDataQuery);
        resultSetCountry = DataBaseUtil.getResultSet(countriesDataQuery);
        resultSetStates = DataBaseUtil.getResultSet(statesDataQuery);

    }

    @Given("user read all  data from database")
    public void user_read_all_data_from_database() throws SQLException {
        //data haric diger bilg verir
        ResultSetMetaData userMetaData = resultSetUser.getMetaData();
        int columnCount = userMetaData.getColumnCount();
        System.out.println(columnCount);

        for (int i = 1; i <= columnCount; i++) {
            System.out.println(userMetaData.getColumnName(i));
        }

        while (resultSetUser.next()) {
            String firstname = resultSetUser.getString("first_name");
            userFirstName.add(firstname);
        }

        System.out.println(userFirstName);
    }
    @Then("user validate all  data")
    public void user_validate_all_data() throws SQLException {
        String userFirstnameQuery = "SELECT first_name FROM " +ConfigReader.getProperty("usersTableName");
        resultSetUser = DataBaseUtil.getResultSet(userFirstnameQuery);
        List<String> actualFirstName = new ArrayList<>();

        while (resultSetUser.next()) {
            String firstname = resultSetUser.getString("first_name");
            actualFirstName.add(firstname);
        }

        Assert.assertEquals(userFirstName,actualFirstName);
    }



    @Given("user read all countries info from database")
    public void user_read_all_countries_info_from_database() throws SQLException {
        ResultSetMetaData countryMetaData = resultSetCountry.getMetaData();
        int columnCount = countryMetaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            System.out.println(countryMetaData.getColumnName(i));
        }

        while (resultSetCountry.next()) {
            String country = resultSetCountry.getString("name");
            countryList.add(country);
        }

        System.out.println(countryList);
    }

    @Then("user validate all countries info")
    public void user_validate_all_countries_info() throws SQLException {
        String countryNameQuery = "SELECT name FROM " + ConfigReader.getProperty("countriesTableName");
        resultSetCountry = DataBaseUtil.getResultSet(countryNameQuery);
        List<String> actualCountry = new ArrayList<>();

        while (resultSetCountry.next()) {
            String firstname = resultSetCountry.getString("name");
            actualCountry.add(firstname);
        }

        Assert.assertEquals(countryList,actualCountry);

    }
    @Given("user read all states of related  to USA from database")
    public void user_read_all_states_of_related_to_USA_from_database() throws SQLException {
        ResultSetMetaData statesMetaData = resultSetStates.getMetaData();
        int columnCount = statesMetaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            System.out.println(statesMetaData.getColumnName(i));
        }

        String statesDataQuery = "SELECT * FROM public.tp_state WHERE name  = ' Ghana' ";
        resultSetStates = DataBaseUtil.getResultSet(statesDataQuery);

        while (resultSetStates.next()) {
            String states = resultSetStates.getString("name");
            statesList.add(states);
        }

        System.out.println(statesList);
    }
    @Then("user validate all states of  related to USA")
    public void user_validate_all_states_of_related_to_USA() throws SQLException {
        String statesDataQuery = "SELECT * FROM public.tp_state";
        resultSetStates = DataBaseUtil.getResultSet(statesDataQuery);
        List<String> allStatesList = new ArrayList<>();


        while (resultSetStates.next()) {
            String states = resultSetStates.getString("name");
            allStatesList.add(states);
        }

        Assert.assertTrue(allStatesList.containsAll(statesList));
    }

}
