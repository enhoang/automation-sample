package src.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManagement {
    private static Properties props = new Properties();

    public static void loadEnv(String env) {
        try {
            FileInputStream fis = new FileInputStream("src/config_env/config.properties");
            props.load(fis);
            props.setProperty("env", env); // ⚠ Ghi đè "env" bằng giá trị từ testng.xml
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static String getEnv() {
        return get("env");
    }

    public static String getUrl() {
        return get("url." + getEnv());
    }

    public static String getHomeUrl() {
        return get("homeurl." + getEnv());
    }

    public static String geteventUrl() {
        return get("eventmanagement_url." + getEnv());
    }

    public static String getvoucherUrl() {
        return get("vouchermanagement_url." + getEnv());
    }

    public static String getemkpUrl() {
        return get("evtMkp_url." + getEnv());
    }

    public static String getvmkpUrl() {
        return get("voucherMkp_url." + getEnv());
    }

    public static String getMerchantText() {
        return get("merchantText." + getEnv());
    }

    public static String geteventTitle() {
        return get("eventTitle." + getEnv());
    }

    public static String getvoucherTitle() {
        return get("voucherTitle." + getEnv());
    }

}

