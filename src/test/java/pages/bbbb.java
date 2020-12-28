package pages;

import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.DatabaseUtility;
import utilities.Driver;
import java.util.ArrayList;
import java.util.List;

public class bbbb {

    static Faker faker = new Faker();
    static String id;
    static List<String> templist;

    public static List<String> testUI() {
        Driver.loginAll("employee");
        Driver.getDriver().findElement(By.xpath("//li[@id=\"entity-menu\"]")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"entity-menu\"]/div/a[1]/span")).click();
        WebElement next = Driver.getDriver().findElement(By.xpath("//ul[@class=\"pagination\"]/li[last()-1]/a"));
        WebElement lastPage = Driver.getDriver().findElement(By.xpath("//ul[@class=\"pagination\"]/li[last()-2]/a"));

        String line1 = "//table[@class='table']/tbody/tr[";
        String line2 = "]/td[1]/a";
        int totalPage = Integer.parseInt(lastPage.getText());
        List<List<String>> list = new ArrayList<>();
        int k = 1;
        int size = Driver.getDriver().findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
        int page = faker.number().numberBetween(1, totalPage);
        int row = faker.number().numberBetween(1, 20);

        while (k < totalPage) {
            for (int i = 1; i <= size; i++) {
                if (k == page && i == row) {
                    Driver.wait(5);
                    id = Driver.getDriver().findElement(By.xpath(line1 + i + line2)).getText();
                    WebElement firstname1 = Driver.getDriver().findElement(By.xpath("//table[@class='table']/tbody/tr[" + i + "]/td[2]"));
                    WebElement lastname1 = Driver.getDriver().findElement(By.xpath("//table[@class='table']/tbody/tr[" + i + "]/td[3]"));
                    WebElement middlename1 = Driver.getDriver().findElement(By.xpath("//table[@class='table']/tbody/tr[" + i + "]/td[4]"));

                    templist = new ArrayList<>();
                    templist.add(firstname1.getText());
                    templist.add(lastname1.getText());
                    templist.add(middlename1.getText());
                    list.add(templist);
                    System.out.println("size : "+totalPage+" - page : "+(page)+" - row "+row+" - id : "+id);
                    System.out.println("UI list  : " + templist);

                }
            }
            k++;
            try {
                next.click();
            } catch (StaleElementReferenceException e) {
                System.out.println("*********************************");
            }
        }
        return list.get(0);

    }
    public static List<Object> testDB() {
        Driver.wait(5);
        DatabaseUtility.createConnection("jdbc:postgresql://157.230.48.97:5432/gmibank_db", "techprodb_user", "Techpro_@126");
        String query = "Select first_name,last_name,middle_initial from tp_customer where id=" + id;
        List<Object> database = DatabaseUtility.getRowList(query);
        System.out.println("DB list  : " + database);

        return database;
    }

    @Test
    public void testUIDB() {

        Assert.assertEquals(testUI(), testDB());

    }

    @AfterClass
    public static void cleanup() {
        DatabaseUtility.closeConnection();
    }

}





