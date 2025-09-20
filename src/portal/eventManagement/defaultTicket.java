package src.portal.eventManagement;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.utils.JsonDataReader;

import java.util.List;

public class defaultTicket extends BaseTest_Portal {
    @Test
    public void defaultTic() {
        /// Default Ticket Types
        WebElement defTicket = driver.findElement(By.xpath("//span[normalize-space()='Default Ticket Types']"));
        defTicket.click();
        Assert.assertEquals(driver.findElement(By.xpath("//h4[normalize-space()='Ticket Types*']")).getText(), "Ticket Types*");

        /// Add more
        WebElement addMore = driver.findElement(By.xpath("//span[normalize-space()='+ Add More']"));
        addMore.click();

        /// Add type 1
            /// Upload thumbnail
            WebElement thumbnail1 = driver.findElement(By.xpath("//span[@class='ant-upload']//input[@id='ticketTypes_ticketTypes_0_ticketImage']"));
            String filePath2 = "src/datafile/portal/forEvent/eventmedia.json";
            List<JSONObject> testDataList2 = JsonDataReader.getTestData(filePath2);
            for (JSONObject data : testDataList2) {
                thumbnail1.sendKeys((String) data.get("defaultImage1"));
            }

            /// Information
            String filePath = "src/datafile/portal/forEvent/single ticket 0.json";
            List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
            for (JSONObject data : testDataList) {
                /// Title
                driver.findElement(By.cssSelector("#ticketTypes_0_title")).sendKeys((String) data.get("name"));
                /// Price
                driver.findElement(By.cssSelector("#ticketTypes_0_price")).sendKeys((String) data.get("price"));
                /// Capacity
                driver.findElement(By.cssSelector("#ticketTypes_0_capacity")).sendKeys((String) data.get("capacity"));
                /// Total Tickets
                driver.findElement(By.cssSelector("#ticketTypes_0_quantity")).sendKeys((String) data.get("total"));
            }

        /// Add Type 2
        addMore.click();
            /// Upload thumbnail
            WebElement thumbnail2 = driver.findElement(By.xpath("//span[@class='ant-upload']//input[@id='ticketTypes_ticketTypes_1_ticketImage']"));
            String filePath3 = "src/datafile/portal/forEvent/eventmedia.json";
            List<JSONObject> testDataList3 = JsonDataReader.getTestData(filePath3);
            for (JSONObject data : testDataList3) {
                thumbnail2.sendKeys((String) data.get("defaultImage2"));
            }
            /// Information
            String filePath1 = "src/datafile/portal/forEvent/single ticket 1.json";
            List<JSONObject> testDataList1 = JsonDataReader.getTestData(filePath1);
            for (JSONObject data : testDataList1) {
                /// Title
                driver.findElement(By.cssSelector("#ticketTypes_1_title")).sendKeys((String) data.get("name1"));
                /// Price
                driver.findElement(By.cssSelector("#ticketTypes_1_price")).sendKeys((String) data.get("price1"));
                /// Capacity
                driver.findElement(By.cssSelector("#ticketTypes_1_capacity")).sendKeys((String) data.get("capacity1"));
                /// Total Tickets
                driver.findElement(By.cssSelector("#ticketTypes_1_quantity")).sendKeys((String) data.get("total1"));
            }
        /// Save
        WebElement save = driver.findElement(By.xpath("//button[@type='submit']"));
        save.click();
        getDefaultTimeout();
        }
}
