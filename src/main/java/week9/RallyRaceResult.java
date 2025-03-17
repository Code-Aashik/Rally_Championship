package week9;

import java.util.ArrayList;
import java.util.List;

public class RallyRaceResult implements RaceResult {
    private String raceName;
    private List<String> results;
    private List<Double> points;

    public RallyRaceResult(String raceName) {
        this.raceName = raceName;
        results = new ArrayList<>();
        points = new ArrayList<>();
    }

    @Override
    public void recordResult(Driver driver, int position, double points) {
        results.add("Position " + position + ": " + driver.getName() + " - " + points + " points");
        this.points.add(points);
        driver.addPoints(points); // Add points to driver's total
    }

    @Override
    public List<String> getResults() {
        return results;
    }

    public String getRaceName() {
        return raceName;
    }

}
