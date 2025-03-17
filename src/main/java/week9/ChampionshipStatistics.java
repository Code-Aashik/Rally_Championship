package week9;

import java.util.List;

public class ChampionshipStatistics {
    public static double calculateAveragePoints(List<Driver> drivers) {
        double totalPoints = drivers.stream().mapToDouble(Driver::getTotalPoints).sum();
        return (double) totalPoints / drivers.size();
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        // Placeholder for actual implementation
        return "Finland"; // Example
    }

    public static int countTotalRaces(List<RaceResult> raceResults) {
        return raceResults.size();
    }
}
