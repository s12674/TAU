package com.pjatk.jbehave;

/**
 * Created by Mateusz on 14.03.2017.
 */

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

@RunWith ( JUnit4. class )
public class RingImplTest {

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @TestSubject
    public Ring ringImpl = new RingImpl();

    @Mock
    public MyTime time;

    @org.junit.Test
    public void ringTest() {
        MyTime timeRing = new MyTimeImpl();
        timeRing.setTime("12", "01", "1994", "12", "00");
        ringImpl.addAlarmTime(timeRing);
        expect(time.getTime())
                .andReturn("120119941200")
                .andReturn("120119941200")
                .andReturn("120119941200")
                .andReturn("110119941200")
                .andReturn("120119941200");
        replay(time);
        assertEquals(true, ringImpl.shouldRing());
        assertEquals(false, ringImpl.shouldRing());
        assertEquals(false, ringImpl.shouldRing());
        assertEquals(false, ringImpl.shouldRing());
        assertEquals(true, ringImpl.shouldRing());
        verify(time);
    }
    @org.junit.Test
    public void clearRingTest() {
        MyTime timeRing = new MyTimeImpl();
        timeRing.setTime("12", "01", "1994", "12", "00");
        ringImpl.addAlarmTime(timeRing);
        expect(time.getTime()).andReturn("120119941202").anyTimes();
        replay(time);
        assertEquals(true, ringImpl.shouldRing());
        ringImpl.clearAlarmTime(timeRing);
        assertEquals(false, ringImpl.shouldRing());
        verify(time);
    }
}
