package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main {
    private static final String PATH = "src/result.json";

    public static void main(String[] args) {
        ArrayList<Result> resultList = new ArrayList<>();

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(PATH));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray results = (JSONArray) jsonObject.get("results");

            for (Object result : results) {
                JSONObject resultObj = (JSONObject) result;

                for (Object test : resultObj.values()) {
                    JSONArray testArray = (JSONArray) test;

                    for (Object testObj : testArray) {
                        JSONObject testDetails = (JSONObject) testObj;

                        String testName = (String) testDetails.keySet().iterator().next();
                        JSONObject testInfo = (JSONObject) testDetails.get(testName);

                        String login = resultObj.keySet().iterator().next().toString();
                        String testDate = (String) testInfo.get("date");
                        int testMark = (int) ((double) (testInfo.get("mark")) * 10);

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date utilDate = sdf.parse(testDate);
                        Date sqlDate = new Date(utilDate.getTime());

                        Result resultObject = new Result(login, testName, sqlDate, testMark);
                        resultList.add(resultObject);
                    }
                }
            }

            for (Result result : resultList) {
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}