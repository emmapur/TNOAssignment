import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class RadarDefenseSystemTest {

    @Test
    public void testProcessRadarData_HostileDetected() {
        String[] radarReadings = {"101", "111", "011"}; // 5, 7, 3 (odd majority)
        assertTrue(RadarDefenseSystem.processRadarData(radarReadings), "Hostile should be detected");
    }

    @Test
    public void testProcessRadarData_NoHostileDetected() {
        String[] radarReadings = {"100", "010", "110"}; // 4, 2, 6 (even majority)
        assertFalse(RadarDefenseSystem.processRadarData(radarReadings), "No hostile should be detected");
    }

    @Test
    public void testMissileHitProbability() {
        int hitCount = 0;
        int totalTrials = 10000;
        Random random = new Random();
        for (int i = 0; i < totalTrials; i++) {
            if (random.nextDouble() <= 0.8) {
                hitCount++;
            }
        }
        double estimatedPk = (double) hitCount / totalTrials;
        assertTrue(Math.abs(estimatedPk - 0.8) < 0.05, "Missile hit probability should be close to 0.8");
    }
}
