# Radar Defense System Simulator

## Overview
This application simulates a radar defense system designed to detect potential hostile entities based on radar data and launch a missile in response. It consists of two main classes: `RadarDefenseSystem` and `Simulator`. The `RadarDefenseSystem` class processes radar data to identify possible threats, and the `Simulator` class reads radar data from a file, runs the simulation, and simulates the missile defense system's behavior over time.

## Components

### 1. `RadarDefenseSystem.java`
This class defines the radar defense system, including the logic for detecting threats and launching missiles. It contains the following components:

- **PROBABILITY_OF_KILL**: A constant that defines the likelihood of a missile successfully hitting its target (80% in this case).
- **systemId**: An identifier for the defense system instance (e.g., "System1", "System2").
- **Constructor**: Accepts a `systemId` to assign an identifier to each defense system.
- **processRadarData(String[] radarReadings)**: This method processes the radar data, which is an array of binary strings. It counts the number of odd and even decimal values and returns `true` if the number of odd values exceeds the number of even values (indicating a hostile entity).
- **handleThreat(String[] radarReadings, Random random)**: This method checks if a threat is detected based on radar data, then simulates launching a missile and whether it hits or misses based on the `PROBABILITY_OF_KILL`.

### 2. `Simulator.java`
The simulator class runs the radar defense simulation. It reads radar data from a CSV file and processes it for a fixed number of time steps. It creates instances of `RadarDefenseSystem` and simulates the detection and missile engagement for each time step.

- **SIMULATION_TIME**: A constant defining the number of simulation steps (20 in this case).
- **FILE_NAME**: The path to the radar data CSV file, which should contain binary strings representing radar readings.
- **readRadarData(String fileName)**: This method reads the radar data file (assumed to be in CSV format) and returns it as a list of string arrays (one per time step).
- **runSimulation()**: This method executes the simulation for a predefined number of time steps. It processes radar data and simulates the missile defense system at each time step.
- **main(String[] args)**: This is the entry point of the simulation, calling `runSimulation()` to start the simulation.

## How to Use

1. **Prepare Radar Data**:
   - The radar data should be in a CSV file where each line contains comma-separated binary strings. Each binary string represents a radar reading.
   - Example of radar data format:
     ```
     101010,110011,101101
     110000,111111,100100
     ```

2. **Configure the File Path**:
   - Ensure the `FILE_NAME` constant in `Simulator.java` is set to the correct path where your radar data CSV file is located (e.g., ` ".\\data\\radar_data.csv";`).

3. **Run the Simulation**:
   - Compile and run the `Simulator.java` class. The simulation will read radar data, simulate threat detection and missile engagements, and output the results for each time step.
   - Example Output:
     ```
     Time Step: 1
     [System1] Hostile entity detected! Launching missile...
     [System1] Missile hit the target!
     [System2] No hostile entity detected.
     
     Time Step: 2
     [System1] No hostile entity detected.
     [System2] Hostile entity detected! Launching missile...
     [System2] Missile missed!
     ```

4. **Customize the System**:
   - You can add more defense systems by creating additional instances of `RadarDefenseSystem` in the `Simulator.java` class.
   - You can adjust the simulation time by modifying the `SIMULATION_TIME` constant.
   - You can modify the `PROBABILITY_OF_KILL` in the `RadarDefenseSystem` class to change the missile hit probability.

## Requirements

- Java 8 or higher.
- A radar data CSV file with binary strings representing radar readings.

## Example Usage (Windows PowerShell)

To run the simulation on Windows using PowerShell, follow these steps:

### 1. Run the simulation:
After successfully compiling the classes, run the simulation using the `java` command:

   ```powershell
   java Simulator
   ```

This will execute the `Simulator` class and start the radar defense system simulation. The output will be printed to the PowerShell console, showing the simulation's progress step by step.

---

## Customization and Extensions

- **Multiple Defense Systems**: You can add more defense systems in the simulator to handle different radar zones.
- **Dynamic Radar Data**: Instead of a static CSV file, the radar data can be generated or fetched dynamically.
- **Advanced Threat Detection**: Extend the threat detection logic to consider more complex algorithms such as radar signature analysis, multi-target tracking, etc.
