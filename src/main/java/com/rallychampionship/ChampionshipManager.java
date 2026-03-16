package com.rallychampionship;

import java.util.*;

/**
 * Singleton class that manages the entire rally championship.
 * Only one instance may exist at any time — enforced via a private constructor
 * and a static getInstance() factory method.
 */
public class ChampionshipManager {

    /** The single instance of this class. */
    private static ChampionshipManager instance;

    /** All drivers registered in the championship. */
    private List<Driver> drivers;

    /** All race results added to the championship. */
    private List<RallyRaceResult> races;

    /** Static counter tracking the total number of races held. */
    private static int totalRaces = 0;

    /**
     * Private constructor prevents external instantiation.
     */
    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }

    /**
     * Returns the single ChampionshipManager instance, creating it on first call.
     * @return the singleton ChampionshipManager
     */
    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    /**
     * Registers a driver in the championship.
     * @param driver the driver to register
     */
    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    /**
     * Adds a completed race result and increments the race counter.
     * @param result the completed race result
     */
    public void addRaceResult(RallyRaceResult result) {
        races.add(result);
        totalRaces++;
    }

    /**
     * Returns drivers sorted by points in descending order.
     * @return sorted standings list
     */
    public static List<Driver> getDriverStandings() {
        ChampionshipManager mgr = getInstance();
        List<Driver> sorted = new ArrayList<>(mgr.drivers);
        sorted.sort((a, b) -> b.getPoints() - a.getPoints());
        return sorted;
    }

    /**
     * Returns the driver currently leading the championship.
     * @return the leading driver, or null if no drivers are registered
     */
    public static Driver getLeadingDriver() {
        List<Driver> standings = getDriverStandings();
        return standings.isEmpty() ? null : standings.get(0);
    }

    /**
     * Calculates the sum of all drivers' points.
     * @return total championship points across all drivers
     */
    public static int getTotalChampionshipPoints() {
        int total = 0;
        for (Driver d : getInstance().drivers) {
            total += d.getPoints();
        }
        return total;
    }

    /** @return unmodifiable list of all registered drivers */
    public List<Driver> getDrivers() {
        return Collections.unmodifiableList(drivers);
    }

    /** @return unmodifiable list of all race results */
    public List<RallyRaceResult> getRaces() {
        return Collections.unmodifiableList(races);
    }

    /** @return total number of races held */
    public static int getTotalRaces() {
        return totalRaces;
    }

    /** Resets the singleton (used for re-initialisation). */
    public static void reset() {
        instance = null;
        totalRaces = 0;
    }
}
