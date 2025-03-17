package week9;

import java.util.Arrays;
import java.util.*;
public class RallyChampionshipManagement {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        Driver driver1 = new Driver("Sébastien Ogier", "France");
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland");
        Driver driver3 = new Driver("Ott Tänak", "Estonia");
        Driver driver4 = new Driver("Thierry Neuville", "Belgium");

        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);

        // Simulate races and record results
        RallyRaceResult race1 = new RallyRaceResult("Rally Finland (Jyväskylä)");
        race1.recordResult(driver1, 1, 25);
        race1.recordResult(driver3, 2, 18);
        race1.recordResult(driver2, 3, 15);
        race1.recordResult(driver4, 4, 12);
        manager.recordRaceResult(race1);

        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally (Monaco)");
        race2.recordResult(driver2, 1, 25);
        race2.recordResult(driver4, 2, 18);
        race2.recordResult(driver1, 3, 15);
        race2.recordResult(driver3, 4, 12);
        manager.recordRaceResult(race2);

        // Calculate standings
        manager.calculateStandings();

        // Display championship standings
        
        int position = 1; // Initialize position counter
for (Driver driver : manager.getDrivers()) {
    System.out.println(position + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getTotalPoints() + " points");
    position++;
}

        // Display championship leader
        Driver leader = manager.getChampionshipLeader();
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(leader.getName() + " with " + leader.getTotalPoints() + " points");

        // Display championship statistics
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + manager.getTotalDrivers());
        System.out.println("Total Races: " + manager.getTotalRaces());
        System.out.printf("Average Points Per Driver: %.2f%n", manager.calculateAveragePoints());
        System.out.println("Most Successful Country: " + manager.findMostSuccessfulCountry());
        System.out.println("Total Championship Points: " + manager.getTotalChampionshipPoints());

        // Display race results
        System.out.println("\n===== RACE RESULTS =====");
        for (RaceResult result : manager.getRaceResults()) {
            System.out.println("Race: " + ((RallyRaceResult) result).getRaceName());
            for (String res : result.getResults()) {
                System.out.println(res);
            }
        }

        // Display car performance ratings
        RallyCar gravelCar = new GravelCar("Ford", "Fiesta", 283.33);
        RallyCar asphaltCar = new AsphaltCar("Toyota", "Yaris", 262.2);
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + gravelCar.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar.calculatePerformance());
    }
}
