package Methods.menstrualApp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class menstrualCycleTest {
    @Test
    public void testToGetNextPeriod(){
        LocalDate startDate = LocalDate.of(2025, 4, 03);
        menstrualCycle mc = new menstrualCycle(startDate,28,5);
        LocalDate nextDate = LocalDate.of(2025, 5, 01);
        assertEquals(nextDate,mc.getNextPeriod());

    }


    @Test
    public void testToGetovulationDate(){
        LocalDate startDate = LocalDate.of(2025, 4, 03);
        menstrualCycle mc = new menstrualCycle(startDate,28,5);
        LocalDate nextDate = LocalDate.of(2025, 5, 15);
        assertEquals(nextDate,mc.getovulationDate());
    }

    @Test
    public void testToGetdaysToFertility(){
        LocalDate startDate = LocalDate.of(2025, 4, 03);
        menstrualCycle mc = new menstrualCycle(startDate,28,5);
        LocalDate nexEndtDate = LocalDate.of(2025, 5, 15);
        LocalDate nextDate = LocalDate.of(2025, 5, 8);
        assertEquals(nextDate +" to "+nexEndtDate,mc.getFertilityDate());
    }

    @Test
    public void testToGetdaysOfFlow(){
        LocalDate startDate = LocalDate.of(2025, 4, 03);
        menstrualCycle mc = new menstrualCycle(startDate,28,5);
        LocalDate nexEndtDate = LocalDate.of(2025, 5, 01);
        LocalDate nextDate = LocalDate.of(2025, 4, 26);
        assertEquals(nextDate +" to "+nexEndtDate,mc.getFlowDate());
    }

    @Test
    public void testToGetSavedays(){
        LocalDate startDate = LocalDate.of(2025, 4, 03);
        menstrualCycle mc = new menstrualCycle(startDate,28,5);
        LocalDate nexEndtDate = LocalDate.of(2025, 5, 16);
        LocalDate nextDate = LocalDate.of(2025, 5, 29);
        assertEquals(nextDate +" to "+nexEndtDate,mc.getSaveDays());
    }

}