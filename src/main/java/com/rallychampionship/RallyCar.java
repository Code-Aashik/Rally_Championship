package com.rallychampionship;

/**
 * Abstract base class representing a rally car.
 * Follows the Open/Closed Principle: open for extension, closed for modification.
 * Subclasses must implement calculatePerformance() with their own algorithm.
 */
public abstract class RallyCar {

    private String make;
    private String model;
    private int horsepower;

    /**
     * Constructs a RallyCar with the given specifications.
     * @param make       the manufacturer of the car
     * @param model      the model name of the car
     * @param horsepower the engine horsepower
     */
    public RallyCar(String make, String model, int horsepower) {
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    /** @return the car make */
    public String getMake() { return make; }

    /** @return the car model */
    public String getModel() { return model; }

    /** @return the engine horsepower */
    public int getHorsepower() { return horsepower; }

    /**
     * Calculates a performance rating specific to the car type.
     * @return a double representing the performance rating
     */
    public abstract double calculatePerformance();
}
