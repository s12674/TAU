package pjwstk;

/**
 * Created by Mateusz on 14.03.2017.
 */
public class MyTimeImpl implements MyTime{
    private String year, day, month, hour, min;

    @Override
    public String getTime() {
        return (day + month + year + hour + min);
    }

    @Override
    public void setTime(String day, String month, String year, String hour, String min) {
        this.year = year;
        this.day = day;
        this.month = month;
        this.hour = hour;
        this.min = min;
    }
}
