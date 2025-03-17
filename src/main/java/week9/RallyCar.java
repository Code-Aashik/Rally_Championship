package week9;

public abstract class RallyCar {
    protected String make;
    protected String model;
    protected double horsepower;

    public RallyCar(String make, String model, double horsepower) {
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    public abstract double calculatePerformance();
    
}
