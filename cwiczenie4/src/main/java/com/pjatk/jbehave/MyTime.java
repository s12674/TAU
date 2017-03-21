package com.pjatk.jbehave;

/**
 * Created by Mateusz on 14.03.2017.
 */
public interface MyTime {
    public String getTime();
    public void setTime(String day, String month, String year, String hour, String min);
    public void setTimeString(String date);
}
