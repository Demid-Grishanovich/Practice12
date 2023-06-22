package org.example;

import java.sql.Date;

public class Result {
    private final String login;
    private final String test;
    private java.sql.Date date;
    private int mark;

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

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getStringMark() {
        return mark / 10 + "." + mark % 10;
    }

    public String toString() {
        return String.format("%s;%s;%s;%s", login, test, date.toString(), getStringMark());
    }
}