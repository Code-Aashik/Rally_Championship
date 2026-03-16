package com.rallychampionship;

/**
 * Represents a rally driver competing in the championship.
 * Uses dependency injection to receive a RallyCar (Dependency Inversion Principle).
 */
public class Driver {

    /** Tracks the total number of Driver objects created (static member). */
    private static int totalDrivers = 0;

    private String name;
    private String country;
    private int points;

    /** The car currently assigned to this driver. */
    private RallyCar car;

    /**
     * Constructs a Driver and increments the static driver counter.
     * @param name    the driver's full name
     * @param country the driver's country of origin
     * @param car     the rally car assigned to this driver
     */
    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
        this.points = 0;
        totalDrivers++;
    }

    /** @return the driver's name */
    public String getName() { return name; }

    /** @return the driver's country */
    public String getCountry() { return country; }

    /** @return the driver's current total points */
    public int getPoints() { return points; }

    /** @return the car currently assigned to this driver */
    public RallyCar getCar() { return car; }

    /**
     * Replaces the driver's current car (demonstrates car switching between races).
     * @param car the new RallyCar to assign
     */
    public void setCar(RallyCar car) { this.car = car; }

    /**
     * Adds championship points to this driver's total.
     * @param points the number of points to add
     */
    public void addPoints(int points) { this.points += points; }

    /**
     * Returns the total number of Driver instances created.
     * @return total driver count
     */
    public static int getTotalDrivers() { return totalDrivers; }

    /** Resets the static driver counter. */
    public static void resetTotalDrivers() { totalDrivers = 0; }

    @Override
    public String toString() {
        return name + " (" + country + "): " + points + " points";
    }
}
