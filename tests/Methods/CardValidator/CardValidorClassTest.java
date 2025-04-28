package Methods.CardValidator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardValidorClassTest {
    @Test
    public void testthefirstsum(){
        CardValidorClass cv = new CardValidorClass("4388576018402626");
        assertEquals(37,cv.getFirstSum());


    }
    @Test
    public void testtheSecondsum(){
        CardValidorClass cv = new CardValidorClass("4388576018402626");
        assertEquals(38,cv.getSecondSum());


    }

    @Test
    public void testToCheckInvalid(){
        CardValidorClass cv = new CardValidorClass("4388576018402626");
        assertEquals("invalid",cv.checkNumber());
    }

    @Test
    public void testToCheckInvalidII(){
        CardValidorClass cv = new CardValidorClass("4388576018410707");
        assertEquals("Valid",cv.checkNumber());

    }

    @Test
    public void testToCheckTheTypeOfCard(){
        CardValidorClass cv = new CardValidorClass("4388576018410707");
        assertEquals("Visa Cards",cv.checkType());
    }
}