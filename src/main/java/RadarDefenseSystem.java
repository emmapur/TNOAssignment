import java.io.*;
import java.util.*;

public class RadarDefenseSystem {
    private static final double PROBABILITY_OF_KILL = 0.8;
    private final String systemId;

    // Constructor allowing us to assign an identifier to each system instance
    public RadarDefenseSystem(String systemId) {
        this.systemId = systemId;
    }

    // Processes the radar readings (provided as an array of binary strings)
    // Counts the number of odd and even decimal values
    // Returns true if odd count is greater than even count (hostile detected)
    public static boolean processRadarData(String[] radarReadings) {
        int oddCount = 0, evenCount = 0;
        for (String binaryString : radarReadings) {
            int decimalValue = Integer.parseInt(binaryString, 2);
            if (decimalValue % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return oddCount > evenCount;
    }

    // Checks for a threat based on the radar readings and simulates missile engagement
    public void handleThreat(String[] radarReadings, Random random) {
        boolean hostileDetected = processRadarData(radarReadings);
        if (hostileDetected) {
            System.out.println("[" + systemId + "] Hostile entity detected! Launching missile...");
            boolean hit = random.nextDouble() <= PROBABILITY_OF_KILL;
            System.out.println(hit ? "[" + systemId + "] Missile hit the target!" : "[" + systemId + "] Missile missed!");
        } else {
            System.out.println("[" + systemId + "] No hostile entity detected.");
        }
    }
}