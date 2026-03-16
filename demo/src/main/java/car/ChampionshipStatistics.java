package car;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ChampionshipStatistics {

    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        if (drivers.size() == 0) {
            return 0;
        }
        int totalPoints = ChampionshipManager.getTotalChampionshipPoints();

        return (double) totalPoints / drivers.size();
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {

        Map<String, Integer> countryPoints = new HashMap<>();

        for (Driver driver : drivers) {

            String country = driver.getCountry();
            int points = driver.getPoints();

            if (countryPoints.containsKey(country)) {
                int currentPoints = countryPoints.get(country);
                countryPoints.put(country, currentPoints + points);
            } 
            else {
                countryPoints.put(country, points);
            }
        }

        String bestCountry = "N/A";
        int maxPoints = 0;

        for (Map.Entry<String, Integer> entry : countryPoints.entrySet()) {

            String country = entry.getKey();
            int points = entry.getValue();

            if (points > maxPoints) {
                maxPoints = points;
                bestCountry = country;
            }
        }

        return bestCountry;
    }

    public static int getTotalRacesHeld() {
        return ChampionshipManager.getTotalRacesCount();
    }
}