package pjwstk;

/**
 * Created by Mateusz on 14.03.2017.
 */
public class MyTimeImpl implements MyTime{
    private int year, day, month, hour, min;

    @Override
    public String getTime() {
        return (Integer.toString(day) + Integer.toString(month) + Integer.toString(year) + Integer.toString(hour) + Integer.toString(min));
    }

    @Override
    public void setTime(int day, int month, int year, int hour, int min) {
        this.year = year;
        this.day = day;
        this.month = month;
        this.hour = hour;
        this.min = min;
    }
}
