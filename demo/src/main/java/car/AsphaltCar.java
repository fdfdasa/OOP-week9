package car;
/**
 * Represents a car optimized for asphalt with specific aerodynamic attributes.
 */
public class AsphaltCar extends RallyCar {
    private double downforce;

    public AsphaltCar(String make, String model, int horsepower, double downforce) {
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    public double getDownforce() {
        return downforce;
    }

    @Override
    public double calculatePerformance() {
        // Performance is boosted by higher downforce on smooth asphalt
        return this.getHorsepower() * (1.1 + (downforce / 1000.0));
    }
}
