package src.customer.a0_pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import src.base.BaseTest_Customer;
import src.utils.JsonDataReader;

import java.time.Duration;
import java.util.List;

public class LoginByPhone extends BaseTest_Customer {
    @Test
    public void loginSMS() {
        /// Login button in Homepage
        open();
        waitForClickable(By.xpath("//*[@id=\"root\"]/div[3]/div[1]/div/div[2]/div[2]/div"));
        waitForClickable(By.xpath("/html/body/div[2]/div[3]/div[3]/button"));

        /// Password Login
        waitForClickable(By.xpath("/html/body/div[1]/div[1]/ul/li[2]"));

        /// Select country phone code
        String filePath = "src/datafile/customer/login-phone.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            String code = (String) data.get("code");

            /// Select phone code
            waitForVisible(By.xpath("//button//p[contains(text(),'+65')]"));
            WebElement container = driver.findElement(By.xpath("//button//p[contains(text(),'+65')]"));
            waitForClickable(container);

            WebElement phoneCode = driver.findElement(By.xpath("//p[normalize-space()='" + code + "']"));
            waitForVisible(phoneCode);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", container, phoneCode);
            phoneCode.click();
            getDefaultTimeout();
            driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();

        /// Input phone number
        WebElement phoneNumber = driver.findElement(By.cssSelector("input[placeholder='Phone number']"));
        phoneNumber.sendKeys((String) data.get("phone number"));

        /// Input password
        WebElement password = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        password.sendKeys((String) data.get("password"));
        }
        /// Login
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        waitForVisible(By.cssSelector(".MuiBox-root.css-6zxyxx"));
    }
}
