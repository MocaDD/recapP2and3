package P2;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class IuliusParkingLotTest {

    // It shouldn't pass, because there is no available place for the car -> the parking lot is full
    @Test
    public void isParkingPlaceAvailable() {
        IuliusParkingLot parkingLot = new IuliusParkingLot();
        parkingLot.fillParkingLotWithCars(100);
        assertTrue(parkingLot.isParkingPlaceAvailable(new Vehicle("Car")));
    }

    // It should pass, because there is an available place for the car
    @Test
    public void parkCarWhenThereIsAPlaceAvailable() {
        IuliusParkingLot parkingLot = new IuliusParkingLot();
        parkingLot.fillParkingLotWithCars(99);
        assertTrue(parkingLot.parkCar());
    }

    // It shouldn't pass, because the available places are on different rows
    @Test
    public void parkBusOnDifferentRows() {
        IuliusParkingLot parkingLot = new IuliusParkingLot();
        parkingLot.setParkingLot(0, 56);
        parkingLot.setParkingLot(62, 99);

        assertTrue(parkingLot.parkBus());
    }

    // It should pass, because the available places are on the same row
    @Test
    public void parkBusOnTheSameRow() {
        IuliusParkingLot parkingLot = new IuliusParkingLot();
        parkingLot.setParkingLot(0, 40);
        parkingLot.setParkingLot(46, 99);

        assertTrue(parkingLot.parkBus());
    }

    // It shouldn't pass, the bus is already parked when the car wants to park, so there is not parking place available for the car.
    @Test
    public void parkBothCarAndBus() {
        IuliusParkingLot parkingLot = new IuliusParkingLot();
        parkingLot.setParkingLot(0, 50);
        parkingLot.setParkingLot(56, 99);
        assertTrue(parkingLot.parkBus());
        assertTrue(parkingLot.parkCar());
    }


    // With car it shouldn't pass, because the parking lot is full with busses, without car it should pass.
    @Test
    public void parkMultipleVehicles() {
        IuliusParkingLot parkingLot = new IuliusParkingLot();
        for (int i = 0; i < 20; i++) {
            assertTrue(parkingLot.parkBus());
        }
//        assertTrue(parkingLot.parkCar());
    }

}