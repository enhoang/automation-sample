package src.customer.addVoucher;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import src.customer.a0_pages.P2_Voucher;
import src.base.BaseTest_Customer;
import src.utils.AutoClickHelper;
import src.utils.ConfigManagement;
import src.utils.JsonDataReader;

import java.util.List;

public class addVoucher extends BaseTest_Customer {
    @Test
    public void selectVouchers() {
        /// Open Vouchers page
        P2_Voucher voucher = new P2_Voucher(driver);
        voucher.voucher();

        /// Select voucher 1
        String filePath = "src/datafile/portal/forVoucher/information.json";
        List<JSONObject> testDataList = JsonDataReader.getTestData(filePath);
        for (JSONObject data : testDataList) {
            String voucherTitle = (String) data.get("name");
            waitForClickable(By.xpath("//div[normalize-space()='" + voucherTitle + "']"));
            System.out.println(voucherTitle);
        }
        /// Select quantity
        AutoClickHelper.clickFromJson(driver, "src/datafile/autoclick/voucher/plusVoucher.json"); // Add Voucher
        AutoClickHelper.clickFromJson(driver, "src/datafile/autoclick/voucher/minusVoucher.json"); // Remove Voucher

        /// Add to cart
        waitForClickable(By.xpath("//button[normalize-space()='Add To Cart']"));
    }
}

