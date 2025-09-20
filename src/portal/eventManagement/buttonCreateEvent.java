package src.portal.eventManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import src.base.BaseTest_Portal;
import src.portal.a0_pages.P4_EventManagement;

public class buttonCreateEvent extends BaseTest_Portal {
    @Test
    public void btnCreateEvent() {
        /// Open Events page
        P4_EventManagement eventMgn = new P4_EventManagement(driver);
        eventMgn.eventManagement();

        /// Click button Create Event
        waitForClickable(By.xpath("//span[normalize-space()='Create Event']"));
    }
}
