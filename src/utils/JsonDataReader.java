package src.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonDataReader {

    public static List<JSONObject> getTestData(String filePath) {
        List<JSONObject> dataList = new ArrayList<>();
        try {
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(filePath));

            for (Object obj : jsonArray) {
                dataList.add((JSONObject) obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public static List<JSONObject> getCombinedTestData(String... paths) {
        List<JSONObject> allData = new ArrayList<>();
        JSONParser parser = new JSONParser();
        for (String path : paths) {
            try (FileReader reader = new FileReader(path)) {
                Object obj = parser.parse(reader);
                if (obj instanceof JSONArray) {
                    JSONArray jsonArray = (JSONArray) obj;
                    for (Object item : jsonArray) {
                        if (item instanceof JSONObject) {
                            allData.add((JSONObject) item);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return allData;
    }
}

