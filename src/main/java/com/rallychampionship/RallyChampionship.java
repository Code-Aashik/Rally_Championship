package com.rallychampionship;

import java.util.List;
import java.util.Locale;

/**
 * Main entry point for the Rally Championship Management System.
 * Demonstrates: Singleton pattern, car hierarchy, dependency injection,
 * interface-based race results, static statistics, and car switching.
 */
public class RallyChampionship {

    /**
     * Program entry point.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // ── 1. Get the ChampionshipManager singleton ──────────────────────────
        ChampionshipManager championship = ChampionshipManager.getInstance();

        // ── 2. Create cars for both surface types ─────────────────────────────
        GravelCar ogierGravel    = new GravelCar("Toyota",  "GR Yaris Rally1", 380, 250.0);
        GravelCar rovampGravel   = new GravelCar("Toyota",  "GR Yaris Rally1", 380, 255.0);
        GravelCar tanakGravel    = new GravelCar("Hyundai", "i20 N Rally1",    375, 245.0);
        GravelCar neuvilleGravel = new GravelCar("Hyundai", "i20 N Rally1",    375, 248.0);

        AsphaltCar ogierAsphalt    = new AsphaltCar("Toyota",  "GR Yaris Rally1", 380, 120.0);
        AsphaltCar rovampAsphalt   = new AsphaltCar("Toyota",  "GR Yaris Rally1", 380, 125.0);
        AsphaltCar tanakAsphalt    = new AsphaltCar("Hyundai", "i20 N Rally1",    375, 118.0);
        AsphaltCar neuvilleAsphalt = new AsphaltCar("Hyundai", "i20 N Rally1",    375, 122.0);

        // ── 3. Create and register drivers (gravel cars initially) ────────────
        Driver ogier    = new Driver("Sébastien Ogier",  "France",  ogierGravel);
        Driver rovamp   = new Driver("Kalle Rovanperä",  "Finland", rovampGravel);
        Driver tanak    = new Driver("Ott Tänak",        "Estonia", tanakGravel);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", neuvilleGravel);

        championship.registerDriver(ogier);
        championship.registerDriver(rovamp);
        championship.registerDriver(tanak);
        championship.registerDriver(neuville);

        // ── 4. Race 1: Rally Finland (gravel surface) ─────────────────────────
        RallyRaceResult finlandRace = new RallyRaceResult("Rally Finland", "Jyväskylä");
        finlandRace.recordResult(ogier,    1, 25);
        finlandRace.recordResult(tanak,    2, 18);
        finlandRace.recordResult(rovamp,   3, 15);
        finlandRace.recordResult(neuville, 4, 12);
        championship.addRaceResult(finlandRace);

        // ── 5. Car switching: swap to asphalt cars before Monte Carlo ─────────
        ogier.setCar(ogierAsphalt);
        rovamp.setCar(rovampAsphalt);
        tanak.setCar(tanakAsphalt);
        neuville.setCar(neuvilleAsphalt);

        // ── 6. Race 2: Monte Carlo Rally (asphalt surface) ────────────────────
        RallyRaceResult monteCarloRace = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        monteCarloRace.recordResult(rovamp,   1, 25);
        monteCarloRace.recordResult(neuville, 2, 18);
        monteCarloRace.recordResult(ogier,    3, 15);
        monteCarloRace.recordResult(tanak,    4, 12);
        championship.addRaceResult(monteCarloRace);

        // ── 7. Championship standings ─────────────────────────────────────────
        List<Driver> standings = ChampionshipManager.getDriverStandings();
        int rank = 1;
        for (Driver d : standings) {
            System.out.println(rank + ". " + d.getName()
                    + " (" + d.getCountry() + "): " + d.getPoints() + " points");
            rank++;
        }

        // ── 8. Championship leader ────────────────────────────────────────────
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        Driver leader = ChampionshipManager.getLeadingDriver();
        if (leader != null) {
            System.out.println(leader.getName() + " with " + leader.getPoints() + " points");
        }

        // ── 9. Championship statistics ────────────────────────────────────────
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        List<Driver> allDrivers = championship.getDrivers();
        System.out.println("Total Drivers: " + Driver.getTotalDrivers());
        System.out.println("Total Races: "   + ChampionshipStatistics.getTotalRacesHeld());

        double avg = ChampionshipStatistics.calculateAveragePointsPerDriver(allDrivers);
        System.out.printf(Locale.forLanguageTag("fi"), "Average Points Per Driver: %.2f%n", avg);

        System.out.println("Most Successful Country: "
                + ChampionshipStatistics.findMostSuccessfulCountry(allDrivers));
        System.out.println("Total Championship Points: "
                + ChampionshipManager.getTotalChampionshipPoints());

        // ── 10. Race results ──────────────────────────────────────────────────
        System.out.println("\n===== RACE RESULTS =====");
        for (RallyRaceResult race : championship.getRaces()) {
            race.printResults();
        }

        // ── 11. Car performance ratings ───────────────────────────────────────
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.printf("Gravel Car Performance: %.1f%n",  ogierGravel.calculatePerformance());
        System.out.printf("Asphalt Car Performance: %.1f%n", ogierAsphalt.calculatePerformance());
    }
}
