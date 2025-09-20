package src.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.time.Duration;

public class AutoClickHelper {
    // Wait for element then click
    public static void waitAndClick(WebDriver driver, By locator, int waitSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (Exception e) {
            System.out.println("Click failed for locator " + locator + ": " + e.getMessage());
        }
    }

    // Multiple click
    public static void clickMultipleTimes(WebDriver driver, By locator, int times, int waitBeforeClickMs) {
        for (int i = 0; i < times; i++) {
            waitAndClick(driver, locator, 10); // wait up to 10s for element can click
            try {
                Thread.sleep(waitBeforeClickMs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void clickFromJson(WebDriver driver, String filePath) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(filePath));
            JSONArray clickList = (JSONArray) jsonObject.get("clicks");

            for (Object obj : clickList) {
                JSONObject clickObj = (JSONObject) obj;
                String locator = (String) clickObj.get("locator");
                String type = (String) clickObj.get("type");
                int times = Integer.parseInt(clickObj.get("times").toString());
                int waitBeforeClickMs = clickObj.get("waitBeforeClick") != null
                        ? Integer.parseInt(clickObj.get("waitBeforeClick").toString())
                        : 300; // default 300ms

                By byLocator;
                switch (type.toLowerCase()) {
                    case "xpath":
                        byLocator = By.xpath(locator);
                        break;
                    case "id":
                        byLocator = By.id(locator);
                        break;
                    case "name":
                        byLocator = By.name(locator);
                        break;
                    case "text": // build contains text
                        byLocator = By.xpath("//div[contains(normalize-space(), '" + locator + "')]");
                        break;
                    case "css":
                    default:
                        byLocator = By.cssSelector(locator);
                        break;
                }

                System.out.println("Clicking: " + locator + " (" + type + ") x " + times);
                clickMultipleTimes(driver, byLocator, times, waitBeforeClickMs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickFromMultipleJson(WebDriver driver, String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));

        if (files != null) {
            for (File file : files) {
                System.out.println("\n=== Running clicks from: " + file.getName() + " ===");
                clickFromJson(driver, file.getAbsolutePath());
            }
        } else {
            System.out.println("No JSON files found in: " + folderPath);
        }
    }
}