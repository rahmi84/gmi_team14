package stepdefinitions;

import io.cucumber.core.gherkin.Feature;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {


    @Before
    public void setUp(){

        //System.out.println("setUp Çalıştı.");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



        System.out.println("setUp ...");

    }


    @After
    public void tearDown(Scenario scenario){
        System.out.println( "   Scenario is executed     :  "+scenario.getName());
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if(scenario.isFailed()){
            scenario.embed(screenshot , "image/png");
        }


       Driver.close();

    }



}



