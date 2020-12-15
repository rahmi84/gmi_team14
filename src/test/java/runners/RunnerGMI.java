package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-cucumber-reports",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},
        features = "src/test/resources/features",
        glue = "stepdefinitions",


      tags = "@db",
        dryRun = false



      tags = "@US07",
      dryRun = false


    //      tags = "@US06",

        tags="@US15_SmokeTest",
        dryRun = false


        //  tags = "@db",

       // dryRun = true
r

)
public class RunnerGMI {


}

