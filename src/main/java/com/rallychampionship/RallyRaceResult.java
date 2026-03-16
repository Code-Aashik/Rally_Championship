package com.rallychampionship;

import java.util.*;

/**
 * Concrete implementation of the RaceResult interface.
 * Stores the race name, location, and a map of driver finishing positions to points.
 */
public class RallyRaceResult implements RaceResult {

    private String raceName;
    private String location;

    /** Maps each driver to the points they earned. Insertion order = finishing order. */
    private Map<Driver, Integer> results;

    /**
     * Constructs a RallyRaceResult for the given event.
     * @param raceName the name of the rally event
     * @param location the location/city of the event
     */
    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.results = new LinkedHashMap<>();
    }

    /** @return the race name */
    public String getRaceName() { return raceName; }

    /** @return the race location */
    public String getLocation() { return location; }

    /**
     * Records a driver result and awards points to the driver immediately.
     * @param driver   the finishing driver
     * @param position the finishing position
     * @param points   championship points to award
     */
    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
        driver.addPoints(points);
    }

    /**
     * Returns points earned by a specific driver in this race.
     * @param driver the driver to look up
     * @return points earned, or 0 if not found
     */
    @Override
    public int getDriverPoints(Driver driver) {
        return results.getOrDefault(driver, 0);
    }

    /**
     * Returns the list of drivers in finishing order.
     * @return ordered list of drivers
     */
    @Override
    public List<Driver> getResults() {
        return new ArrayList<>(results.keySet());
    }

    /** Prints formatted race results to standard output. */
    public void printResults() {
        System.out.println("Race: " + raceName + " (" + location + ")");
        int position = 1;
        for (Map.Entry<Driver, Integer> entry : results.entrySet()) {
            System.out.println("  Position " + position + ": "
                    + entry.getKey().getName() + " - " + entry.getValue() + " points");
            position++;
        }
    }
}
