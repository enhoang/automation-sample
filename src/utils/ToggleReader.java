package src.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.FileReader;

public class ToggleReader {
    private static JSONObject toggleData;
    static {
        try {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader("src/datafile/portal/toggleSetting.json");
            toggleData = (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isToggleEnabled(String toggleName) {
        Object value = toggleData.get(toggleName);
        return value != null && Boolean.parseBoolean(value.toString());
    }

    public static String getToggleValue(String key) {
        Object value = toggleData.get(key);
        return value != null ? value.toString() : "";
    }
}
