package P3;

public class TestCar {

    public static double TestCar(Car testedCar) {
        while (true) {
            testedCar.turnOnAndDrive(10);
            if (!testedCar.isBrokenDown()) {
                if (testedCar.getGallons() == 0)
                    testedCar.fillGas(10);
            } else {
                return testedCar.getMileage();
            }
        }
    }
}