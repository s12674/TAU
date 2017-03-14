package pjwstk;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz on 14.03.2017.
 */
public class RingImpl implements Ring {
    boolean ring;
    boolean mark;
    List<MyTime> timeList = new ArrayList<MyTime>();
    MyTime time;

    @Override
    public boolean shouldRing() {
        String t = time.getTime();
        ring = false;
        for(MyTime e : timeList){
            Long test = (Long.parseLong(t) - Long.parseLong(e.getTime()));
            if((e.getTime().equals(t)) || test < 3 && test >=0) {
                if(!mark){
                    ring = true;
                    mark = true;
                }
                else{
                    ring = false;
                }
            }
            else{
                mark = false;
                ring = false;
            }
        }
        return ring;
    }

    @Override
    public void addAlarmTime(MyTime time) {
        timeList.add(time);
    }

    @Override
    public void clearAlarmTime(MyTime time) {
        timeList.remove(time);
    }
}
