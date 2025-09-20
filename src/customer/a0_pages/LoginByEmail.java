package src.customer.a0_pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import src.base.BaseTest_Customer;
import src.utils.JsonDataReader;

import java.time.Duration;
import java.util.List;

public class LoginByEmail extends BaseTest_Customer {
    @Test
    public void loginbyEmail() {
        /// Login button in Homepage
        open();
        waitForClickable(By.xpath("//*[@id=\"root\"]/div[3]/div[1]/div/div[2]/div[2]/div"));
        waitForClickable(By.xpath("/html/body/div[2]/div[3]/div[3]/button"));

        /// Password Login
        waitForClickable(By.xpath("/html/body/div[1]/div[1]/ul/li[2]"));

        /// Login by Email
        waitForClickable(By.xpath("/html/body/div[1]/div[1]/form/div/button[1]"));
        String filePath = "src/datafile/customer/login-account.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys((String) data.get("email"));
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys((String) data.get("password"));
        }
        /// Login
        driver.findElement(By.className("btn-primary")).click();
        waitForVisible(By.cssSelector(".MuiBox-root.css-6zxyxx"));
        }
    }
