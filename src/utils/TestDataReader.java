package src.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class TestDataReader {
    public static void main(String[] args) {
    try {
        JSONParser parser = new JSONParser();
        JSONArray dataArray = (JSONArray) parser.parse(new FileReader("src/test/resources/testdata.json"));

        for (Object obj : dataArray) {
            JSONObject data = (JSONObject) obj;
            System.out.println("Card Holder: " + data.get("cardholder"));
            System.out.println("Email: " + data.get("email"));
            System.out.println("Phone: " + data.get("mobile"));
            System.out.println("Bank name: " + data.get("bank_name"));
            System.out.println("Description: " + data.get("desc"));
        }
    } catch (Exception e) {
        e.printStackTrace();
            }
        }
    }