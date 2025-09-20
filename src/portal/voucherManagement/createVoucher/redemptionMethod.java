package src.portal.voucherManagement.createVoucher;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.utils.JsonDataReader;

import java.util.List;

import static src.utils.ToggleReader.isToggleEnabled;

public class redemptionMethod extends BaseTest_Portal {
    @Test
    public void redemption() {
        String filePath = "src/datafile/portal/forVoucher/redemptionMethod.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            String method = (String) data.get("method");
            if (method == null) {
                throw new IllegalArgumentException("Method is null in JSON file!");
            } else {
                System.out.println(method);
            }

            /// Select Method
            WebElement redemptionMethod = driver.findElement(By.cssSelector("#redemptionMethod"));
            redemptionMethod.click();

            /// Run cases
            switch (method.toUpperCase()) {
                case "PIN":
                    waitForClickable(By.xpath("//span[normalize-space()='PIN Code']"));
                    /// Enter PIN
                    waitForVisible(By.cssSelector("#pinCodes_0_code"));
                    JSONArray pinArray = (JSONArray) data.get("pin");
                    for (int i = 0; i < pinArray.size(); i++) {
                        String pinCode = (String) pinArray.get(i);
                        if (i == 0) { // PIN 1
                            WebElement pinField = driver.findElement(By.cssSelector("#pinCodes_0_code"));
                            pinField.sendKeys(pinCode);
                        } else {
                            /// Add PIN
                            WebElement addButton = driver.findElement(By.xpath("//span[normalize-space()='+ Add Pin Code']"));
                            addButton.click();
                            /// Enter new PIN
                            String pinFieldCss = "#pinCodes_" + i + "_code";
                            waitForVisible(By.cssSelector(pinFieldCss));
                            WebElement pinField = driver.findElement(By.cssSelector(pinFieldCss));
                            pinField.sendKeys(pinCode);
                        }
                    }
                    break;
                case "QR":
                    waitForClickable(By.xpath("//span[normalize-space()='QR Scan']"));
                    if (isToggleEnabled("qrDynamic")) {
                        WebElement qrDynamic = driver.findElement(By.xpath("//button[@id='isQrcodeDynamic']"));
                        if (!qrDynamic.isSelected()) {
                            qrDynamic.click();
                        }
                    }
                    break;

                case "SWIPE":
                    waitForClickable(By.xpath("//span[normalize-space()='Swipe']"));
                    break;

                default:
                    System.out.println("Unknown Method: " + method);
            }
        }
    }
}
