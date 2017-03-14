package pjwstk;

import java.sql.Time;

/**
 * Created by Mateusz on 14.03.2017.
 */
public interface Ring {
    public boolean shouldRing();
    public void addAlarmTime(MyTime time);
    public void clearAlarmTime(MyTime time);
}
