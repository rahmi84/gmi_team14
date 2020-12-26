package pages;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class aaaa {


    public static void main(String[] args) {
        String idFind = "61009";
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

}



