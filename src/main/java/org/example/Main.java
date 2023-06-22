package org.example;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String PATH = "src/result.json";
    private static final String RESULTS = "results";
    private static final String DATE = "date";
    public static final String MARK = "mark";

    public static void main(String[] args) {
        try (FileReader reader = new FileReader(PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);

            JSONArray results = (JSONArray) root.get(RESULTS);

            List<Result> resultsList = new ArrayList<>();
            for (Object result : results) {
                JSONObject resultJson = (JSONObject) result;
                String login = (String) resultJson.keySet().iterator().next();
                JSONArray resultArray = (JSONArray) resultJson.get(login);

                for (Object o : resultArray) {
                    JSONObject test = (JSONObject) o;
                    String testName = (String) test.keySet().iterator().next();
                    JSONObject details = (JSONObject) test.get(testName);
                    String date = (String) details.get(DATE);
                    Double mark = (Double) details.get(MARK);
                    resultsList.add(new Result(login, testName, date, mark));
                }
            }

            for (Result res : resultsList) {
                System.out.println(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}