package week9;
class GravelCar extends RallyCar{
    public GravelCar(String make, String model, double horsepower) {
        super(make, model, horsepower);
    }

    @Override
    public double calculatePerformance() {
        return horsepower * 1.5;
    }
}
