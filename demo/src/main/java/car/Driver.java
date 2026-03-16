package car;

public class Driver {
    private String name;
    private String country;
    private int points;
    private RallyCar car;

    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.points = 0;
        this.car = car;
    }

    /* Getters */
    public String getName() { return name; }
    public String getCountry() { return country; }
    public int getPoints() { return points; }
    public RallyCar getCar() { return car; }

    /* Change car */
    public void setCar(RallyCar car) { this.car = car; }

    public void addPoints(int points) {
        this.points += points;
    }
}
