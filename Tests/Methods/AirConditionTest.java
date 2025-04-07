package Methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AirConditionTest{
    @Test
    public void testTheSwitchbutton(){
        AirCondition myControl = new AirCondition();
        assertTrue(myControl.power());
    }

    @Test
    public void testTheSwitchbuttonAndOff(){
        AirCondition myControl = new AirCondition();
        myControl.power();
        assertFalse(myControl.power());
    }

    @Test
    public void testThatTempCanIncrease(){
        AirCondition myControl = new AirCondition();
        myControl.power();
        assertEquals("21",myControl.increse());

    }

    @Test
    public void testThatTempCanIncreaseAgain(){
        AirCondition myControl = new AirCondition();
        myControl.power();
        myControl.increse();
        assertEquals("22",myControl.increse());

    }

    @Test
    public void testTheHighestDegreeItCanReach(){
        AirCondition myControl = new AirCondition();
        myControl.power();
        for(int count=1; count<=9;count++) {
            myControl.increse();
        }
        assertEquals("30",myControl.increse());
    }

    @Test
    public void testThatIfTheTempCanPassTheHighest(){
        AirCondition myControl = new AirCondition();
        myControl.power();
        for(int count=0; count<=10;count++) {
            myControl.increse();
        }
        assertEquals("The air condition at its highest",myControl.increse());
    }

    @Test
    public void testWantToIncreaseToMax(){
        AirCondition myControl = new AirCondition();
        myControl.power();
        assertEquals("30",myControl.max());
    }

    @Test
    public void testThatACIncreseWhenOff(){
        AirCondition myControl = new AirCondition();
        assertEquals("Air condition is off",myControl.increse());
    }

    @Test
    public void testThatACMaxWhenOff(){
        AirCondition myControl = new AirCondition();
        assertEquals("Air condition is off",myControl.max());
    }


    @Test
    public void testThatTempCanDecrease(){
        AirCondition myControl = new AirCondition();
        myControl.power();
        assertEquals("19",myControl.decrese());
    }


    @Test
    public void testThatTempCanDecreaseAgain(){
        AirCondition myControl = new AirCondition();
        myControl.power();
        myControl.decrese();
        assertEquals("18",myControl.decrese());
    }

    @Test
    public void testThatIfTheTempCanReachTheLowest(){
        AirCondition myControl = new AirCondition();
        myControl.power();
        for (int count=1; count<=3;count++){
            myControl.decrese();
        }
        assertEquals("16",myControl.decrese());

    }


    @Test
    public void testThatIfTheTempCanPassTheLowest(){
        AirCondition myControl = new AirCondition();
        myControl.power();
        for (int count=1; count<=4;count++){
            myControl.decrese();
        }
        assertEquals("ac is at it coldest",myControl.decrese());

    }

    @Test
    public void testWantToIncreaseToMin(){
        AirCondition myControl = new AirCondition();
        myControl.power();
        assertEquals("16",myControl.Min());
    }

    @Test
    public void testThatACDecreseWhenOff(){
        AirCondition myControl = new AirCondition();
        assertEquals("Air condition is off",myControl.decrese());
    }


    @Test
    public void testThatACMinWhenOff(){
        AirCondition myControl = new AirCondition();
        assertEquals("Air condition is off",myControl.Min()  );
    }


    @Test
    public void testThatAllMethodWorkTogether(){
        AirCondition myControl = new AirCondition();
        myControl.power();
        myControl.Min();
        myControl.decrese();
        myControl.decrese();
        assertEquals("17",myControl.increse());
    }

    @Test
    public void testThatAllMethodWorkTogetherII(){
        AirCondition myControl = new AirCondition();
        myControl.power();
        myControl.max();
        myControl.decrese();
        myControl.decrese();
        assertEquals("29",myControl.increse());
    }
}

