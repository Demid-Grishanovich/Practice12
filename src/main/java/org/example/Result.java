package org.example;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Result {
    private String login;
    private String test;
    private java.sql.Date date;
    private int mark;

    private final static SimpleDateFormat OUTPUT_DATE_FORMAT =
            new SimpleDateFormat("dd.MM.yyyy");

    public Result(String login, String test, Date date, int mark) {
        this.login = login;
        this.test = test;
        this.date = date;
        this.mark = mark;
    }

    public Result() {
        this.login = "";
        this.test = "";
        this.date = null;
        this.mark = 0;
    }
    public Result(String login, String test, String date, Double mark){
        this.login = login;
        this.test = test;
        this.date = Date.valueOf(date);
        this.mark = (int)(mark * 10);
    }

    public String getLogin() {
        return login;
    }

    public String getTest() {
        return test;
    }

    public Date getDate() {
        return date;
    }

    public int getMark() {
        return mark;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getStringMark() {
        return mark / 10 + "." + mark % 10;
    }
    public String getStringDate() {
        return OUTPUT_DATE_FORMAT.format(date);
    }
    public String toString() {
        return String.format("%s;%s;%s;%s", login, test, getStringDate(), getStringMark());
    }
}