package car;

import java.util.List;

public class RallyChampionship {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // Register Drivers
        GravelCar car1 = new GravelCar("Toyota", "GR Yaris", 368, 32.5);
        AsphaltCar car2 = new AsphaltCar("Hyundai", "i20 N", 363, 450.0);

        Driver d1 = new Driver("Sébastien Ogier", "France", car1);
        Driver d2 = new Driver("Kalle Rovanperä", "Finland", car1);
        Driver d3 = new Driver("Ott Tänak", "Estonia", car2);
        Driver d4 = new Driver("Thierry Neuville", "Belgium", car2);

        manager.registerDriver(d1);
        manager.registerDriver(d2);
        manager.registerDriver(d3);
        manager.registerDriver(d4);

        // Simulate Race 1 (Finland)
        RallyRaceResult finland = new RallyRaceResult("Rally Finland", "Jyväskylä");
        finland.recordResult(d1, 1, 25);
        finland.recordResult(d3, 2, 18);
        finland.recordResult(d2, 3, 15);
        finland.recordResult(d4, 4, 12);
        manager.addRaceResult(finland);

        // Demonstrate Car Switching
        d2.setCar(new AsphaltCar("Toyota", "GR Yaris Asphalt", 368, 480.0));

        // Simulate Race 2 (Monte Carlo)
        RallyRaceResult monaco = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        monaco.recordResult(d2, 1, 20);
        monaco.recordResult(d4, 2, 18);
        monaco.recordResult(d1, 3, 15);
        monaco.recordResult(d3, 4, 12);
        manager.addRaceResult(monaco);

        // Output results 
        List<Driver> standings = manager.getDriverStandings();
        standings.forEach(d -> System.out.println(d.getName() + " (" + d.getCountry() + "): " + d.getPoints() + " points"));

        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(ChampionshipManager.getLeadingDriver().getName() + " with " + ChampionshipManager.getLeadingDriver().getPoints() + " points");

        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.getTotalRacesHeld());
        System.out.printf("Average Points: %.2f\n", ChampionshipStatistics.calculateAveragePointsPerDriver(standings));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(standings));
        System.out.println("Total Points: " + ChampionshipManager.getTotalChampionshipPoints());

        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + car1.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + car2.calculatePerformance());
    }
}