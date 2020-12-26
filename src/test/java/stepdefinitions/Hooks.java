package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.US13EmployeeManageAccountsPage;
import utilities.Driver;

public class Hooks {


    @Before
    public void setUp(){

        //System.out.println("setUp Çalıştı.");



        System.out.println("setUp Çalıştı.");

    }


    @After
    public void tearDown(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if(scenario.isFailed()){
            scenario.embed(screenshot , "image/png");
        }

//        Driver.closeDriver();
    }



}



