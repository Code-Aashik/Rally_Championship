package week9;

public class AsphaltCar extends RallyCar {
    public AsphaltCar(String make, String model, double horsepower) {
        super(make, model, horsepower);
    }


    @Override
    public double calculatePerformance() {
        return horsepower * 1.8;
    }
    
}
