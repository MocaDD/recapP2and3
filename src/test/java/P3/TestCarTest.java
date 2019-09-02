package P3;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestCarTest {

    Car testedCar = new Car(10,0);

    @Test
    public void testCar() {
        System.out.println(TestCar.TestCar(testedCar));
    }
}