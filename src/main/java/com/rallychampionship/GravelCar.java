package com.rallychampionship;

/**
 * Concrete rally car optimised for gravel surfaces.
 * Demonstrates the Liskov Substitution Principle: can be used anywhere a RallyCar is expected.
 */
public class GravelCar extends RallyCar {

    /** Long-travel suspension (mm) that improves gravel performance. */
    private double suspensionTravel;

    /**
     * Constructs a GravelCar with the given specifications.
     * @param make             the manufacturer of the car
     * @param model            the model name
     * @param horsepower       the engine horsepower
     * @param suspensionTravel the suspension travel in millimetres
     */
    public GravelCar(String make, String model, int horsepower, double suspensionTravel) {
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
    }

    /** @return suspension travel in millimetres */
    public double getSuspensionTravel() { return suspensionTravel; }

    /**
     * Calculates gravel performance using horsepower and suspension travel.
     * Formula: (horsepower * 1.2) + (suspensionTravel * 0.5)
     * @return the gravel performance rating
     */
    @Override
    public double calculatePerformance() {
        return (getHorsepower() * 1.2) + (suspensionTravel * 0.5);
    }
}
