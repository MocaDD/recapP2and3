package P3;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    Car myCar = new Car(10.0, 1000.0, 25);

    @Test
    public void turnOnAndDrive25Miles() {

        assertTrue(myCar.turnOnAndDrive(25));
        assertEquals(9, myCar.getGallons(), 0.1);
        assertEquals(1025, myCar.getMileage(), 0.1);
    }

    @Test
    public void turnOnAndDrive250Miles() {

        myCar.turnOnAndDrive(25);
        assertFalse(myCar.turnOnAndDrive(250));
        assertEquals(0,myCar.getGallons(),0.1);
        assertEquals(1250, myCar.getMileage(),0.1);
    }

    @Test
    public void turnOnAndDrive25000Miles() {
        Car myCar = new Car(10.0, 1000.0, 25);

        assertFalse(myCar.turnOnAndDrive(25000));
    }

    @Test
    public void repairTest()    {
        myCar.repair();
        assertFalse(myCar.isBrokenDown());
    }
}