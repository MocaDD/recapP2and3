package P3;

public enum MILES_PER_GALLON {
    MILES_PER_GALLON_AUDI(25);

    private double miles;

    MILES_PER_GALLON(double miles) {
        this.miles = miles;
    }

    public double getMiles() {
        return miles;
    }
}
