package week9;

public class Driver {
    private String name;
    private String country;
    private double totalPoints;

    public Driver(String name, String country) {
        this.name = name;
        this.country = country;
        this.totalPoints = 0;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void addPoints(double points) {
        this.totalPoints += points;
    }
}
