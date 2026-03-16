package car;

/**
 * Abstract base class representing a generic rally car.
 */
public abstract class RallyCar {
    protected String make;
    protected String model;
    protected int horsepower;

    public RallyCar(String make, String model, int horsepower) {
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    /**
     * Calculates the performance rating of the car.
     * @return performance rating as a double.
     */
    public abstract double calculatePerformance();
    
    // Getters
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getHorsepower() { return horsepower; }
}