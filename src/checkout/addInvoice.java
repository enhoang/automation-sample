package src.checkout;

import src.base.BaseTest_Customer;
import src.utils.JsonDataReader;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

public class addInvoice extends BaseTest_Customer {

    @Test
    public void fillPaymentForm() {
        waitForClickable(By.xpath("//input[@id='cardnumber']"));
        waitForClickable(By.cssSelector(".ptr[src='/MOLPay/images/icons/sel.gif'][onclick=\"put_value('4111111111111111','111',12,2027,'VISA');\"]"));

        //Enter information
        String filePath = "src/datafile/checkout/invoice_data.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            driver.findElement(By.name("cardholder")).clear();
            driver.findElement(By.name("cardholder")).sendKeys((String) data.get("cardholder"));
            driver.findElement(By.name("email")).clear();
            driver.findElement(By.name("email")).sendKeys((String) data.get("email"));
            driver.findElement(By.name("mobile")).clear();
            driver.findElement(By.name("mobile")).sendKeys((String) data.get("mobile"));
            driver.findElement(By.name("bank_name")).sendKeys((String) data.get("bank_name"));
            driver.findElement(By.name("desc")).sendKeys((String) data.get("desc"));
        }

        //Select bank country
        waitForClickable(By.xpath("//div[@id='main']//div[@class='field']//span[1][1]//input[1]"));

        //Terms and pay
        driver.findElement(By.cssSelector("#terms")).click();
        driver.findElement(By.cssSelector("#pay")).click();
        waitForVisible(By.xpath("//h1[normalize-space()='Payment']"));
    }
}