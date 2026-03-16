package car;

import java.util.List;

public class RallyChampionship {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // Register car
        GravelCar car1 = new GravelCar("Toyota", "GR Yaris", 368, 15.0); 
        AsphaltCar car2 = new AsphaltCar("Hyundai", "i20 N", 363, 200.0); 

        // Register drivers
        Driver d1 = new Driver("Sébastien Ogier", "France", car1);
        Driver d2 = new Driver("Kalle Rovanperä", "Finland", car1);
        Driver d3 = new Driver("Ott Tänak", "Estonia", car2);
        Driver d4 = new Driver("Thierry Neuville", "Belgium", car2);

        manager.registerDriver(d1);
        manager.registerDriver(d2);
        manager.registerDriver(d3);
        manager.registerDriver(d4);

        // Race 1: Finland
        RallyRaceResult finland = new RallyRaceResult("Rally Finland", "Jyväskylä");
        finland.recordResult(d1, 1, 25);
        finland.recordResult(d3, 2, 18);
        finland.recordResult(d2, 3, 15);
        finland.recordResult(d4, 4, 12);
        manager.addRaceResult(finland);

        // DEMONSTRATE CAR SWITCHING 
        System.out.println("Switching cars for the Monte Carlo asphalt...");
        d1.setCar(car2); // Ogier switches to the AsphaltCar
        d2.setCar(car2); // Rovanperä switches to the AsphaltCar

        // Race 2: Monte Carlo
        RallyRaceResult monaco = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        monaco.recordResult(d2, 2, 29);
        monaco.recordResult(d4, 1, 30);
        monaco.recordResult(d1, 3, 15);
        monaco.recordResult(d3, 4, 12);
        manager.addRaceResult(monaco);


        // 1. Output Standings
        List<Driver> standings = ChampionshipManager.getDriverStandings();
        for (int i = 0; i < standings.size(); i++) {
            Driver d = standings.get(i);
            System.out.println((i + 1) + ". " + d.getName() + " (" + d.getCountry() + "): " + d.getPoints() + " points");
        }

        // 2. Championship Leader
        System.out.println("\n===== CHAMPIONSHIP LEADER =====\n");
        System.out.println(ChampionshipManager.getLeadingDriver().getName() + " with " + ChampionshipManager.getLeadingDriver().getPoints() + " points");

        // 3. Statistics
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====\n");
        System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.getTotalRacesHeld());
        System.out.printf("Average Points Per Driver: %.2f\n", ChampionshipStatistics.calculateAveragePointsPerDriver(standings));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(standings));
        System.out.println("Total Championship Points: " + ChampionshipManager.getTotalChampionshipPoints());

        // 4. Detailed Race Results
        System.out.println("\n===== RACE RESULTS =====\n");
        for (RallyRaceResult race : manager.getAllRaceResults()) {
            System.out.println("\nRace: " + race.getRaceName() + " (" + race.getLocation() + ")");
            List<Driver> participants = race.getResults();
            for (int i = 0; i < participants.size(); i++) {
                Driver p = participants.get(i);
                System.out.println("Position " + (i + 1) + ": " + p.getName() + " - " + race.getDriverPoints(p) + " points");
            }
        }

        // 5. Performance
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====\n");
        System.out.println("Gravel Car Performance: " + car1.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + car2.calculatePerformance());
    }
}