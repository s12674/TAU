package com.pjatk.jbehave;

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
    String actualTime = "";

    @Override
    public boolean shouldRing() {
        if(actualTime.equals("")){
            actualTime = time.getTime();
        }
        ring = false;
        for(MyTime e : timeList){
            Long test = (Long.parseLong(actualTime) - Long.parseLong(e.getTime()));
            if((e.getTime().equals(actualTime)) || test < 3 && test >=0) {
                if(!mark){
                    ring = true;
                    mark = true;
                    break;
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
        actualTime = "";
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

    @Override
    public void setActualTime(String actualTime){
        this.actualTime = actualTime;
    }
}
