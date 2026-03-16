package com.rallychampionship;

import java.util.List;

/**
 * Interface defining the contract for recording and retrieving race results.
 * Demonstrates the Interface Segregation Principle: focused solely on race result operations.
 */
public interface RaceResult {

    /**
     * Records a result for a driver at a given finishing position with earned points.
     * @param driver   the driver who finished the race
     * @param position the finishing position (1 = winner)
     * @param points   the championship points awarded
     */
    void recordResult(Driver driver, int position, int points);

    /**
     * Returns the championship points earned by a specific driver in this race.
     * @param driver the driver to look up
     * @return the points earned, or 0 if the driver is not in results
     */
    int getDriverPoints(Driver driver);

    /**
     * Returns the ranked list of drivers in finishing order.
     * @return list of drivers sorted by position
     */
    List<Driver> getResults();
}
