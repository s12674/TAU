package com.pjatk.jbehave;

/**
 * Created by Mateusz on 21.03.2017.
 */

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class RingSteps {
    Ring ring;
    MyTime time;

    @Given("We re getting some $alarms to set alarm clock for her")
    public void setTime(String alarm){
        ring  = new RingImpl();
        time = mock(MyTime.class);
        given(time.getTime()).willReturn(alarm);
        ring.addAlarmTime(time);
    }

    @When("When Your alarm and actual time: $actualDate will be almost same, You will hear some noises")
    public void alarmsAdded(String actualDate){
        ring.setActualTime(actualDate);
    }

    @Then("This is the result: $result when its true You are hero who saved Queen! :D")
    public void result(Boolean result) {
        assertEquals(result, ring.shouldRing());
    }
}
