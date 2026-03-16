package car;

/**
 * Represents a rally car optimized for gravel surfaces.
 */
public class GravelCar extends RallyCar {
    private double suspensionTravel;

    public GravelCar(String make, String model, int horsepower, double suspensionTravel) {
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
    }

    public double getSuspensionTravel() {
        return suspensionTravel;
    }

    @Override
    public double calculatePerformance() {
        // Performance is boosted by better suspension on gravel surfaces
        return this.getHorsepower() * (1.0 + (suspensionTravel / 100.0)); 
    }
}