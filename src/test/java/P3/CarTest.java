package P3;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void turnOnAndDrive() {

        Car myCar = new Car(10.0, 1000.0);

        assertTrue(myCar.turnOnAndDrive(25));
        assertFalse(myCar.turnOnAndDrive(250));
        assertFalse(myCar.turnOnAndDrive(25000));
        myCar.repair();
        assertFalse(myCar.isBrokenDown());
        myCar.getMileage();
        myCar.getGallons();

    }
}