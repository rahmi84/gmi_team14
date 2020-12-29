package pages;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DatabaseUtility;
import utilities.Driver;
import utilities.pdfUtil;

import java.util.Arrays;
import java.util.List;

public class aaaa {


    public static void main(String[] args) {
        String idFind = "39054";
        Driver.loginAll("employee");
        Driver.getDriver().findElement(By.xpath("//li[@id=\"entity-menu\"]")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"entity-menu\"]/div/a[1]/span")).click();
        WebElement next = Driver.getDriver().findElement(By.xpath("//ul[@class=\"pagination\"]/li[last()-1]/a"));
        WebElement lastPage = Driver.getDriver().findElement(By.xpath("//ul[@class=\"pagination\"]/li[last()-2]/a"));

        String line1 = "//table[@class='table']/tbody/tr[";
        String line2 = "]/td[1]/a";
        int totalPage=Integer.parseInt(lastPage.getText());


int k=1;
        int size = Driver.getDriver().findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
        while( k < totalPage  ) {
            for (int i = 1; i <= size; i++) {
                if (Driver.getDriver().findElement(By.xpath(line1 + i + line2)).getText().trim().equals(idFind)) {
                    System.out.println();
                    Driver.clickWithJS(Driver.getDriver().findElement(By.xpath(line1 + i + line2)));
                    WebElement firstname = Driver.getDriver().findElement(By.xpath("//dl[@class=\"jh-entity-details\"]//dd[1]"));
                    WebElement lastname = Driver.getDriver().findElement(By.xpath("//dl[@class=\"jh-entity-details\"]//dd[2]"));
                    WebElement middlename = Driver.getDriver().findElement(By.xpath("//dl[@class=\"jh-entity-details\"]//dd[3]"));
                    System.out.println("Customer firstname is with Cust Id : " + idFind + " = " + firstname.getText());
                    System.out.println("Customer firstname is with Cust Id : " + idFind + " = " + lastname.getText());
                    System.out.println("Customer firstname is with Cust Id : " + idFind + " = " + middlename.getText());
                k=totalPage;
               break;
                }
            }
            k++;
            next.click();

        }
    }

    @Test
    public void databaseDeneme() {
        DatabaseUtility.createConnection("jdbc:postgresql://157.230.48.97:5432/gmibank_db", "techprodb_user", "Techpro_@126");


        String query1 = "Select tp_customer.id,first_name,last_name,ssn, balance from tp_customer  join " +
                "tp_customer_account  on tp_customer.id=tp_customer_account.tpcustomer_id " +
                "join tp_account  on tp_account.id=tp_customer_account.account_id " +
                "where tp_customer.id=61827 order by balance desc" ;

        List<List<Object>> list1 = DatabaseUtility.getQueryResultList(query1);

        List<String>header1= Arrays.asList("id","Firstname", "Lastname",  "ssn","balance");
        pdfUtil.createPdf("GmiBank1.pdf","Team 14 Customer Transaction ",100,"ny.jpg",list1,header1);


        DatabaseUtility.closeConnection();
    }

}



