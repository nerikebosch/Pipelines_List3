import org.junit.jupiter.api.Test;
import se2526.HRCalculator;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HRCalculatorTest {

    @Test
    public void testValidMaxHR(){
        var result = HRCalculator.calculateMaxHR(25);
        assertEquals(195, result);
    }

    @Test
    public void testInvalidMinHR_ageTooHigh() {
        assertThrows(IllegalArgumentException.class,
                ()-> HRCalculator.calculateMaxHR(500));
    }

    @Test
    public void testInvalidMinHR_ageTooLow() {
        assertThrows(IllegalArgumentException.class,
                ()-> HRCalculator.calculateMaxHR(-1));
    }

    // Tests for the getWorkoutZone method
    @Test
    public void testWorkoutZoneBelow() {
        assertEquals("Below Zone", HRCalculator.getWorkoutZone(30, 50));
    }

    @Test
    public void testWorkoutZoneAbove() {
        assertEquals("Above Max", HRCalculator.getWorkoutZone(30, 210));
    }

    @Test
    public void testWorkoutZone1() {
        assertEquals("Zone 1: Warm-up/Maintenance", HRCalculator.getWorkoutZone(30, 105));
    }

    @Test
    public void testWorkoutZone2() {
        assertEquals("Zone 2: Fat Burn/Fitness training", HRCalculator.getWorkoutZone(30, 125));
    }

    @Test
    public void testWorkoutZone3() {
        assertEquals("Zone 3: Aerobic(Endurance training)", HRCalculator.getWorkoutZone(30, 145));
    }

    @Test
    public void testWorkoutZone4() {
        assertEquals("Zone 4: Anaerobic(Hardcore training)", HRCalculator.getWorkoutZone(40, 150));
    }

    @Test
    public void testWorkoutZone5() {
        assertEquals("Zone 5: Maximum effort", HRCalculator.getWorkoutZone(30, 181));
    }
}
