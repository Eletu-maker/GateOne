package TicTac;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacTest {

@Test
    public void testThatPlayeronecanplay(){
    TicTac ticTac = new TicTac();
    assertTrue(ticTac.getplayerone());
    assertFalse(ticTac.getplayertwo());
    ticTac.whoDeyplayNow();
    assertTrue(ticTac.getplayertwo());
    assertFalse(ticTac.getplayerone());
    ticTac.whoDeyplayNow();
    assertTrue(ticTac.getplayerone());
    assertFalse(ticTac.getplayertwo());
}

@Test
    public void testplayerMove(){
    TicTac ticTac = new TicTac();
    ticTac.play(3);
    ticTac.play(3);
    ticTac.play(5);
    ticTac.play(2);
    ticTac.play(1);

    assertEquals("x",ticTac.getBoardPostion(3));

    assertEquals("o",ticTac.getBoardPostion(5));
    assertEquals("x",ticTac.getBoardPostion(2));
    assertEquals("o",ticTac.getBoardPostion(1));

}

    @Test
    public void testcurrentconditionofthegame(){
        TicTac ticTac = new TicTac();
        ticTac.play(3);
        ticTac.play(5);
        ticTac.play(2);
        ticTac.play(1);
        assertEquals("no winner yet",ticTac.checkwin());

    }

    @Test public void testifplayeronecanwin(){
        TicTac ticTac = new TicTac();
        ticTac.play(1);
        ticTac.play(4);
        ticTac.play(2);
        ticTac.play(9);
        ticTac.play(3);
        assertEquals("player one win",ticTac.checkwin());

    }


}