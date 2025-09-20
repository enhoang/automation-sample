package src.portal.eventManagement;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.utils.JsonDataReader;

import java.util.ArrayList;
import java.util.List;

public class eventMedia extends BaseTest_Portal {
    @Test
    public void uploadMedia() {
        String filePath = "src/datafile/portal/forEvent/eventmedia.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            /// Upload banner image
            WebElement uploadBanner = driver.findElement(By.xpath("//span[@class='ant-upload']//input[@type='file']"));
            uploadBanner.sendKeys((String) data.get("thumbnail"));

            /// Upload media
            getDefaultTimeout();
            WebElement uploadMedia = driver.findElement(By.xpath("//span[@role='button']//input[@type='file' and @multiple]"));
            List<String> mediaPaths = new ArrayList<>();
            for (int i = 1; i <= 10; i++) { // tối đa 10 images
                String key = "media" + i;
                if (data.containsKey(key)) {
                    String path = (String) data.get(key);
                    if (path != null && !path.isEmpty()) {
                        mediaPaths.add(path);
                    }
                }
            }

            if (!mediaPaths.isEmpty()) {
                String joinedPaths = String.join("\n", mediaPaths);
                uploadMedia.sendKeys(joinedPaths);
            } else {
                System.out.println("No media file");
            }
        }
    }
}
