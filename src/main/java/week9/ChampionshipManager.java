package week9;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RaceResult> raceResults;

    private ChampionshipManager() {
        drivers = new ArrayList<>();
        raceResults = new ArrayList<>();
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void recordRaceResult(RaceResult result) {
        raceResults.add(result);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<RaceResult> getRaceResults() {
        return raceResults;
    }

    public void calculateStandings() {
        // Sort drivers by total points
        drivers.sort((d1, d2) -> Double.compare(d2.getTotalPoints(), d1.getTotalPoints()));
    }

    public Driver getChampionshipLeader() {
        return drivers.isEmpty() ? null : drivers.get(0);
    }

    public int getTotalDrivers() {
        return drivers.size();
    }

    public int getTotalRaces() {
        return raceResults.size();
    }

    public double calculateAveragePoints() {
        double totalPoints = drivers.stream().mapToDouble(Driver::getTotalPoints).sum();
        return (double) totalPoints / drivers.size();
    }

    public String findMostSuccessfulCountry() {
        // Placeholder for actual implementation
        return "Finland"; // Example
    }

    public double getTotalChampionshipPoints() {
        return drivers.stream().mapToDouble(Driver::getTotalPoints).sum();
    }
}
