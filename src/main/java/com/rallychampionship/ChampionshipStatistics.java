package com.rallychampionship;

import java.util.*;

/**
 * Utility class providing static statistical methods for the championship.
 * All methods are static — this class is never instantiated.
 * Demonstrates the Single Responsibility Principle.
 */
public class ChampionshipStatistics {

    /** Private constructor prevents instantiation of this utility class. */
    private ChampionshipStatistics() {}

    /**
     * Calculates the average points per driver.
     * @param drivers the list of drivers in the championship
     * @return average points per driver, or 0.0 if the list is empty
     */
    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        if (drivers == null || drivers.isEmpty()) return 0.0;
        int total = 0;
        for (Driver d : drivers) {
            total += d.getPoints();
        }
        return (double) total / drivers.size();
    }

    /**
     * Finds the country with the highest total championship points.
     * @param drivers the list of drivers in the championship
     * @return the name of the most successful country, or "N/A" if list is empty
     */
    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        if (drivers == null || drivers.isEmpty()) return "N/A";

        Map<String, Integer> countryPoints = new HashMap<>();
        for (Driver d : drivers) {
            countryPoints.merge(d.getCountry(), d.getPoints(), Integer::sum);
        }

        return countryPoints.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A");
    }

    /**
     * Returns the total number of races held in the championship.
     * @return total races held
     */
    public static int getTotalRacesHeld() {
        return ChampionshipManager.getTotalRaces();
    }
}
