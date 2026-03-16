package car;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RallyRaceResult> races;

    // Static data members to track totals 
    private static int totalDrivers = 0;
    private static int totalRaces = 0;

    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }

    public void addRaceResult(RallyRaceResult result) {
        races.add(result);
        totalRaces++;
    }

    // Static method for standings
    public static List<Driver> getDriverStandings() {
        List<Driver> sortedDrivers = new ArrayList<>(getInstance().drivers);
        for (int i = 0; i < sortedDrivers.size(); i++) {
            for (int j = 0; j < sortedDrivers.size() - 1; j++) {
                if (sortedDrivers.get(j).getPoints() < sortedDrivers.get(j + 1).getPoints()) {
                    Driver temp = sortedDrivers.get(j);
                    sortedDrivers.set(j, sortedDrivers.get(j + 1));
                    sortedDrivers.set(j + 1, temp);
                }
            }
        }
        return sortedDrivers;
    }

    // Static method for leading driver 
    public static Driver getLeadingDriver() {
        List<Driver> allDrivers = getInstance().drivers;
        if (allDrivers.isEmpty()) return null;

        Driver leader = allDrivers.get(0);
        for (Driver d : allDrivers) {
            if (d.getPoints() > leader.getPoints()) {
                leader = d;
            }
        }
        return leader;
    }

    public static int getTotalChampionshipPoints() {
        int total = 0;
        for (Driver d : getInstance().drivers) {
            total += d.getPoints();
        }
        return total;
    }

    public static int getTotalDrivers() { return totalDrivers; }
    public static int getTotalRacesCount() { return totalRaces; }
    
    public List<RallyRaceResult> getAllRaceResults() { return races; }
}