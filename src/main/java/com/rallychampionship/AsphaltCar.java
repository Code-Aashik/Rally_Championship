package com.rallychampionship;

/**
 * Concrete rally car optimised for asphalt/tarmac surfaces.
 * Demonstrates the Liskov Substitution Principle: can be used anywhere a RallyCar is expected.
 */
public class AsphaltCar extends RallyCar {

    /** Aerodynamic downforce (kg) that improves tarmac performance. */
    private double downforce;

    /**
     * Constructs an AsphaltCar with the given specifications.
     * @param make       the manufacturer of the car
     * @param model      the model name
     * @param horsepower the engine horsepower
     * @param downforce  the aerodynamic downforce in kilograms
     */
    public AsphaltCar(String make, String model, int horsepower, double downforce) {
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    /** @return downforce in kilograms */
    public double getDownforce() { return downforce; }

    /**
     * Calculates asphalt performance using horsepower and downforce.
     * Formula: (horsepower * 1.5) + (downforce * 0.8)
     * @return the asphalt performance rating
     */
    @Override
    public double calculatePerformance() {
        return (getHorsepower() * 1.5) + (downforce * 0.8);
    }
}
