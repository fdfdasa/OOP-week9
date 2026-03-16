package car;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {

    private static ChampionshipManager instance;

    private List<Driver> drivers;
    private List<RallyRaceResult> races;

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

    public List<Driver> getDriverStandings() {

        for (int i = 0; i < drivers.size(); i++) {
            for (int j = i + 1; j < drivers.size(); j++) {

                if (drivers.get(j).getPoints() > drivers.get(i).getPoints()) {

                    Driver temp = drivers.get(i);
                    drivers.set(i, drivers.get(j));
                    drivers.set(j, temp);

                }
            }
        }

        return drivers;
    }

    public static Driver getLeadingDriver() {

        ChampionshipManager manager = getInstance();

        if (manager.drivers.size() == 0) {
            return null;
        }

        Driver bestDriver = manager.drivers.get(0);

        for (Driver d : manager.drivers) {

            if (d.getPoints() > bestDriver.getPoints()) {
                bestDriver = d;
            }
        }

        return bestDriver;
    }

    public static int getTotalChampionshipPoints() {

        ChampionshipManager manager = getInstance();

        int total = 0;

        for (Driver d : manager.drivers) {
            total += d.getPoints();
        }

        return total;
    }

    public static int getTotalDrivers() {
        return totalDrivers;
    }

    public static int getTotalRacesCount() {
        return totalRaces;
    }
}