package P2;


public class IuliusParkingLot implements Parking {

    private boolean[] parkingLot = new boolean[100];

    void fillParkingLotWithCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            parkingLot[i] = true;
        }
    }

    public boolean isParkingPlaceAvailable(Vehicle vehicle) {

        int busIndex = 1;

        if (vehicle.getType().equals("Car")) {
            for (int i = 0; i < parkingLot.length; i++) {
                if (!parkingLot[i]) {
                    parkingLot[i] = true;
                    return true;
                }
            }
        } else if (vehicle.getType().equals("Bus")) {
            for (int i = 0; i < (parkingLot.length - 4); i++) {
                if (!parkingLot[i]) {
                    for (int j = 1; j < 5; j++) {
                        if (!parkingLot[i + j]) {
                            busIndex++;
                        } else {
                            i = i + j;
                            busIndex = 1;
                            break;
                        }
                    }
                    if (busIndex == 5) {

                        int firstDigitWithoutBus = Integer.parseInt(Integer.toString(i).substring(0, 1));
                        int firstDigitWithBus = Integer.parseInt(Integer.toString(i + 4).substring(0, 1));
                        if (firstDigitWithBus == firstDigitWithoutBus) {
                            for (int j = i; j <= i + 4; j++) {
                                parkingLot[j] = true;
                            }
                            return true;
                        } else if (i <= 5) {
                            for (int j = i; j <= i + 4; j++) {
                                parkingLot[j] = true;
                            }
                            return true;
                        } else {
                            busIndex = 1;
                        }
                    }
                }
            }
        } else {
            System.out.println("Incompatible type of vehicle.");
        }
        return false;
    }

    public boolean parkCar() {

        return isParkingPlaceAvailable(new Vehicle("Car"));

    }

    public boolean parkBus() {
        return isParkingPlaceAvailable(new Vehicle("Bus"));
    }

    void setParkingLot(int startIndex, int finishIndex) {
        for (int i = startIndex; i <= finishIndex; i++) {
            parkingLot[i] = true;
        }
    }
}