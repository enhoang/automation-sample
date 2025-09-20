package src.portal.voucherManagement.createVoucher;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.utils.JsonDataReader;

import java.util.List;

public class displayTo extends BaseTest_Portal {
    @Test
    public void display() {
        String filePath = "src/datafile/portal/forVoucher/display.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            String display = (String) data.get("display");
            if (display == null) {
                throw new IllegalArgumentException("Display is null in JSON file!");
            } else {
                System.out.println(display);
            }

            /// Select Display To
            sendKeysWithEnter(By.cssSelector("#displayRule"), (String) data.get("display"));

            /// Run cases
            switch (display.toUpperCase()) {
                case "INCLUDE":
                    List<?> tempList = (List<?>) data.get("include");
                    List<String> include = tempList.stream().map(Object::toString).toList();
                    WebElement includeInput = driver.findElement(By.id("phoneCodes"));
                    for (String country : include) {
                        includeInput.sendKeys(country);
                        includeInput.sendKeys(Keys.ENTER);
                    }
                    break;

                case "EXCLUDE":
                    List<?> tempList1 = (List<?>) data.get("exclude");
                    List<String> exclude = tempList1.stream().map(Object::toString).toList();
                    WebElement excludeInput = driver.findElement(By.id("phoneCodes"));
                    for (String country : exclude) {
                        excludeInput.sendKeys(country);
                        excludeInput.sendKeys(Keys.ENTER);
                    }
                    break;

                default:
                    System.out.println("Unknown Method: " + display);
            }
        }
    }
}
