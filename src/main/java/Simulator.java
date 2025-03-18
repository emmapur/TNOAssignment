import java.io.*;
import java.util.*;

public class Simulator {
    
   private static final int SIMULATION_TIME = 20;
    
   private static final String FILE_NAME = getProjectRoot().resolve("data/radar_data.csv").toString();

    private static Path getProjectRoot() {
        return Paths.get(System.getProperty("user.dir"));
    }
    
    // Reads the radar CSV file and returns a list of String arrays (one array per time step)
    public static List<String[]> readRadarData(String fileName) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Each line is assumed to be a comma-separated list of binary strings
                data.add(line.split(","));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return data;
    }

    public static void runSimulation() {
        List<String[]> radarData = readRadarData(FILE_NAME);
        if (radarData.isEmpty()) {
            System.err.println("Failed to read radar data. Exiting simulation.");
            return;
        }

        Random random = new Random();

        // Create multiple defense systems for potential future extension
        List<RadarDefenseSystem> defenseSystems = new ArrayList<>();
        defenseSystems.add(new RadarDefenseSystem("System1"));
        defenseSystems.add(new RadarDefenseSystem("System2"));

        // Run the simulation for a fixed number of time steps
        for (int t = 0; t < SIMULATION_TIME; t++) {
            System.out.println("Time Step: " + (t + 1));

            if (t >= radarData.size()) {
                System.out.println("No radar data available for this time step.");
            } else {
                String[] currentReadings = radarData.get(t);
                // Each defense system processes the same radar data for demonstration
                for (RadarDefenseSystem system : defenseSystems) {
                    system.handleThreat(currentReadings, random);
                }
            }

            try {
                // Pause for 1 second to simulate a real-time step
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Simulation interrupted. Exiting...");
                break;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        runSimulation();
    }
}
