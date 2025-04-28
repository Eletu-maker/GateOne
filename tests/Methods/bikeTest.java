package Methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class bikeTest {
    @Test
    public void testTheSwitchbutton(){
        bike Control = new bike();
        assertTrue(Control.power());
    }

    @Test
    public void testTheSwitchbuttOnAndOff(){
        bike Control = new bike();
        Control.power();
        assertFalse(Control.power());
    }


    @Test
    public void testThatBikeSpeedCanIncrease(){
        bike Control = new bike();
        Control.power();
        assertEquals("acceleration of 1m/s at gear1",Control.increse());
    }

    @Test
    public void testThatBikeSpeedCanIncreasewithinGear1(){
        bike Control = new bike();
        Control.power();
        for (int count=1;count<=14;count++) {
            Control.increse();
        }
        assertEquals("acceleration of 15m/s at gear1",Control.increse());
    }

    @Test
    public void testThatBikeSpeedCanIncreaseAtGear2(){
        bike Control = new bike();
        Control.power();
        for (int count=1;count<=20;count++) {
            Control.increse();
        }
        assertEquals("acceleration of 21m/s at gear2",Control.increse());
    }

    @Test
    public void testThatBikeSpeedCanIncreasewithinGear2(){
        bike Control = new bike();
        Control.power();
        for (int count=1;count<=27;count++) {
            Control.increse();
        }
        assertEquals("acceleration of 28m/s at gear2",Control.increse());
    }

    @Test
    public void testThatBikeSpeedCanIncreaseAtGear3(){
        bike Control = new bike();
        Control.power();
        for (int count=1;count<=23;count++) {
            Control.increse();
        }
        assertEquals("acceleration of 24m/s at gear2",Control.increse());
    }

    @Test
    public void testThatBikeSpeedCanIncreasewithinGear3(){
        bike Control = new bike();
        Control.power();
        for (int count=1;count<=34;count++) {
            Control.increse();
        }
        assertEquals("acceleration of 35m/s at gear3",Control.increse());
    }



    @Test
    public void testThatBikeSpeedCanIncreaseAtGear4(){
        bike Control = new bike();
        Control.power();
        for (int count=1;count<=40;count++) {
            Control.increse();
        }
        assertEquals("acceleration of 41m/s at gear4",Control.increse());
    }

    @Test
    public void testThatBikeSpeedCanIncreasewithinGear4(){
        bike Control = new bike();
        Control.power();
        for (int count=1;count<=56;count++) {
            Control.increse();
        }
        assertEquals("acceleration of 57m/s at gear4",Control.increse());
    }




    @Test
    public void testThatBikeSpeedCandecrease(){
        bike Control = new bike();
        Control.power();
        assertEquals("no speed yet can not decrease",Control.decrease());
    }




    @Test
    public void testThatBikeSpeedCandecreaseI(){
        bike Control = new bike();
        Control.power();
        Control.increse();
        Control.increse();
        Control.increse();
        assertEquals("acceleration of 2m/s at gear1",Control.decrease());
    }


    @Test
    public void testThatBikeSpeedCandecreaseAtGear2(){
        bike Control = new bike();
        Control.power();
        for (int count=1;count<=22;count++) {
            Control.increse();
        }
        assertEquals("acceleration of 21m/s at gear2",Control.decrease());
    }

    @Test
    public void testThatBikeSpeedCanDecreasewithinGear3(){
        bike Control = new bike();
        Control.power();
        for (int count=1;count<=36;count++) {
            Control.increse();
        }
        assertEquals("acceleration of 35m/s at gear3",Control.decrease());
    }


    @Test
    public void testThatBikeSpeedCanDecreasewithinGear4(){
        bike Control = new bike();
        Control.power();
        for (int count=1;count<=56;count++) {
            Control.increse();
        }
        assertEquals("acceleration of 55m/s at gear4",Control.decrease());
    }

    @Test
    public void testThatBikeSpeedCanDecreaseWhenOff(){
        bike Control = new bike();
        for (int count=1;count<=56;count++) {
            Control.increse();
        }
        assertEquals("bike is off",Control.decrease());
    }


    @Test
    public void testThatBikeSpeedCanIncreaseWhenOff(){
        bike Control = new bike();
        for (int count=1;count<=56;count++) {
            Control.increse();
        }
        assertEquals("bike is off",Control.increse());
    }

}